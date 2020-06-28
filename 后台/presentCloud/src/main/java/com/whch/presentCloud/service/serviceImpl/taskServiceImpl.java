package com.whch.presentCloud.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.task;
import com.whch.presentCloud.entity.taskMemory;
import com.whch.presentCloud.mapper.taskMapper;
import com.whch.presentCloud.repository.IRepository.taskMemoryRepository;
import com.whch.presentCloud.service.IService.ITaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-06-26 09:42:12
 * @LastEditors: whc
 * @LastEditTime: 2020-06-26 11:05:12
 */
@Service
public class taskServiceImpl implements ITaskService {

    @Autowired
    private taskMapper taskmapper;
    @Autowired
    private taskMemoryRepository taskM;

    @Override
    public List<Map<String, Object>> getTask(String username, String classId) {
         //得到一个课程的每个学生的详细任务
         List<task> list2 = taskmapper.getTask(Integer.parseInt(classId));
         List<Map<String,Object>> tasks = new ArrayList<>();
         int tasks_count_out_time = 0;
         int tasks_count_in_time = 0;
         for (task tas : list2) {
             HashMap<String,Object> member = new HashMap<String,Object>();
             member.put("taskName", tas.getTask());
             //获得已参与人数
             List<taskMemory> tasks2 = taskM.getMemoryByTaskId(Integer.toString(tas.getId()));
             member.put("number", tasks2.size());
             member.put("experience", tas.getGrade());
            //  taskMemory ta = taskM.getTask(tas.getTask(), Integer.parseInt(username));
            //  if(ta == null)
            //  {
            //      member.put("state", "未参与");
            //  }else{
            //      member.put("state", ta.getIsparticipate());
            //  }
             
             Date now= new Date();
             if(now.after(tas.getLastsubmittime()) ){
                 member.put("timeState", "已结束");
                 tasks_count_out_time += 1;
             }else{
                 member.put("timeState", "进行中");
                 tasks_count_in_time += 1;
             }
             
             tasks.add(member);
         }
         
        return tasks;
    }
    
}
