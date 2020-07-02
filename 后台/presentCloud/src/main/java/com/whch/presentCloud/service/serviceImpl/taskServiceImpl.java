package com.whch.presentCloud.service.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.ResponseData;
import com.whch.presentCloud.entity.task;
import com.whch.presentCloud.entity.taskMemory;
import com.whch.presentCloud.mapper.classCourseMemberMapper;
import com.whch.presentCloud.mapper.taskMapper;
import com.whch.presentCloud.repository.IRepository.taskMemoryRepository;
import com.whch.presentCloud.service.IService.ITaskService;
import com.whch.presentCloud.utils.ResponseDataUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-06-26 09:42:12
 * @LastEditors: whc
 * @LastEditTime: 2020-06-30 19:12:41
 */
@Service
public class taskServiceImpl implements ITaskService {

    @Autowired
    private taskMapper taskmapper;
    @Autowired
    private taskMemoryRepository taskM;
    @Autowired
    private classCourseMemberMapper courseM;

    @Override
    public HashMap<String, Object> getTask(String username, String classId) {
        // 得到一个课程的每个学生的详细任务
        List<task> list2 = taskmapper.getTask(Integer.parseInt(classId));
        HashMap<String, Object> res = new HashMap<String, Object>();
        if (list2 == null) {
            // tabs
            List<Map<String, Object>> tabs = new ArrayList<>();
            HashMap<String, Object> tab1 = new HashMap<String, Object>();
            tab1.put("title", "全部");
            tab1.put("count", 0);
            HashMap<String, Object> tab2 = new HashMap<String, Object>();
            tab2.put("title", "进行中");
            tab2.put("count", 0);
            HashMap<String, Object> tab3 = new HashMap<String, Object>();
            tab3.put("title", "已结束");
            tab3.put("count", 0);
            tabs.add(tab1);
            tabs.add(tab2);
            tabs.add(tab3);
            res.put("tabs", tabs);
            return res;
        }
        List<Map<String, Object>> tasks = new ArrayList<>();
        int tasks_count_out_time = 0;
        int tasks_count_in_time = 0;
        for (task tas : list2) {
            HashMap<String, Object> member = new HashMap<String, Object>();
            member.put("taskName", tas.getTask());
            // 获得已参与人数
            List<taskMemory> tasks2 = taskM.getMemoryByTaskId(Integer.toString(tas.getId()));
            member.put("number", tasks2.size());
            member.put("experience", tas.getGrade());
            member.put("detail",tas.getGradepoint());
            member.put("workId", tas.getId());
            // taskMemory ta = taskM.getTask(tas.getTask(), Integer.parseInt(username));
            // if(ta == null)
            // {
            // member.put("state", "未参与");
            // }else{
            // member.put("state", ta.getIsparticipate());
            // }

            Date now = new Date();
            if (now.after(tas.getLastsubmittime())) {
                member.put("timeState", "已结束");
                tasks_count_out_time += 1;
            } else {
                member.put("timeState", "进行中");
                tasks_count_in_time += 1;
            }

            tasks.add(member);
        }
        res.put("tasks", tasks);

        // tabs
        List<Map<String, Object>> tabs = new ArrayList<>();
        HashMap<String, Object> tab1 = new HashMap<String, Object>();
        tab1.put("title", "全部");
        tab1.put("count", tasks_count_out_time + tasks_count_in_time);
        HashMap<String, Object> tab2 = new HashMap<String, Object>();
        tab2.put("title", "进行中");
        tab2.put("count", tasks_count_out_time + tasks_count_in_time);
        HashMap<String, Object> tab3 = new HashMap<String, Object>();
        tab3.put("title", "已结束");
        tab3.put("count", 0);
        tabs.add(tab1);
        tabs.add(tab2);
        tabs.add(tab3);
        res.put("tabs", tabs);

        return res;

    }

    @Override
    public String addTask(String username, String classId, String detail, String scroeMax, String endtime,
            String title) {
        Date now = new Date();
        String da = 1900 + now.getYear() + "年" + endtime.substring(0, 6) + " " + endtime.substring(7, 9) + ":00:00";
        SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date sr=null;
        try {
            sr = formater.parse(da);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        task tas = new task(Integer.parseInt(username),detail,title,Integer.parseInt(classId),Integer.parseInt(scroeMax),sr);
        if(taskmapper.insertSelective(tas) == 1){
            return "ok";
        }
        return "false";
    }

    @Override
    public ResponseData submitTask(String username, String workId, String workcontent) {
        task tas = taskmapper.selectByPrimaryKey(Integer.parseInt(workId));
        Date now = new Date();
        if(now.after(tas.getLastsubmittime())){
            return ResponseDataUtil.success("false", "最晚提交时间已过，如果提交，请联系老师");
        }
        taskMemory taskm = new taskMemory(null,Integer.parseInt(username),1,tas.getGrade(),workcontent,workId,tas.getClassid(),tas.getScoringmethod(),tas.getLastsubmittime());
        taskMemory taskme =taskM.getTask(workId, Integer.parseInt(username));
        if(taskme == null){
            if(taskM.add(taskm) == 1){
                 //获得经验值
                 int expe = tas.getGrade();
                 int nowExpe = courseM.getCourse(tas.getClassid().toString(), username).getExperience() + expe;
                 courseM.updateExperience(tas.getClassid(),username,nowExpe);
                return ResponseDataUtil.success("ok", "提交成功");
            }

        }else{
            if(taskM.update(taskm) == 1){
                return ResponseDataUtil.success("ok", "更新任务成功");
            }
        }
        
        return ResponseDataUtil.success("false", "页面不见了");
    }
    
}
