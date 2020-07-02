/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-04-17 18:06:32
 * @LastEditors: whc
 * @LastEditTime: 2020-07-02 12:04:39
 */ 
package com.whch.presentCloud.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.ResponseData;
import com.whch.presentCloud.entity.checkInHistory;
import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.signin;
import com.whch.presentCloud.entity.sysparameter;
import com.whch.presentCloud.entity.task;
import com.whch.presentCloud.entity.taskMemory;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.checkInHistoryMapper;
import com.whch.presentCloud.mapper.classCourseMemberMapper;
import com.whch.presentCloud.mapper.classLessonMapper;
import com.whch.presentCloud.mapper.signinMapper;
import com.whch.presentCloud.mapper.taskMapper;
import com.whch.presentCloud.mapper.userInfoMapper;
import com.whch.presentCloud.repository.IRepository.classLessonRepository;
import com.whch.presentCloud.repository.IRepository.signinRepository;
import com.whch.presentCloud.repository.IRepository.taskMemoryRepository;
import com.whch.presentCloud.repository.IRepository.taskRepository;
import com.whch.presentCloud.service.IService.IClassManageService;
import com.whch.presentCloud.service.IService.ISysparameterService;
import com.whch.presentCloud.utils.Distance;
import com.whch.presentCloud.utils.IPUtils;
import com.whch.presentCloud.utils.ResponseDataUtil;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class classManageServiceImpl implements IClassManageService {

    @Autowired
    private classLessonRepository classLessonR;
    @Autowired
    private classCourseMemberMapper courseM;
    @Autowired
    private taskMemoryRepository taskM;
    @Autowired
    private signinRepository siginR;
    @Autowired
    private taskMapper taskmapper;
    @Autowired
    private signinMapper siginM;
    @Autowired
    private checkInHistoryMapper checkInHistoryM;
    @Autowired
    private userInfoMapper userM;
    @Autowired
    private ISysparameterService sysparameterService;
    @Autowired
    private classLessonMapper classLessonM;

    @Override
    public List<classCourseMember> getLessons(String number) {

        return courseM.get(number);
    }

    /**
     * 学生添加班课
     */
    public String addCourse(String classId, String studentId) {
        // TODO Auto-generated method stub
        if(courseM.getCourse(classId, studentId) != null){
            return "您已加入班课，不能重复添加";
        }
        // 课程成员
        classCourseMember course1 = new classCourseMember();
        course1.setClassid(Integer.parseInt(classId));
        course1.setStudentid(studentId);
        classLesson classL = classLessonR.getLesson(Integer.parseInt(classId));
        userInfo user = userM.findOneByNumber(studentId);
        course1.setTeacherid(classL.getTeacherid());
        course1.setExperience(0);
        course1.setClassname(classL.getClassname());
        course1.setTeachername(classL.getTeachername());
        course1.setStudentname(user.getName());
        int flag = courseM.insertSelective(course1);
        if (flag == 0) {
            return "false";
        }
        return "ok";
    }

    @Override
    public HashMap<String, Object> getCourse(String classId) {
        classLesson lesson = classLessonR.getLesson(Integer.parseInt(classId));
        HashMap state = new HashMap<String, Object>();
        if (lesson == null) {
            state.put("state", "false");
            state.put("messege", "不存在该班课！");
            return state;
        }
        if (lesson.getType() == null) {
           
        HashMap h = new HashMap<String, Object>();
        h.put("state", "ok");
        h.put("bankeName", lesson.getClassname());
        h.put("profilePhoto", "");
        h.put("teacher", lesson.getTeachername());
        h.put("classId", lesson.getClassid());
        h.put("school", lesson.getCollege());
        h.put("department", lesson.getClassname());
        h.put("description", lesson.getType());
        h.put("semester", lesson.getClasstime());
        // list.add(h);
        return h;
        }
        // List<Map> list = new ArrayList<>();

        state.put("state", "false");
        state.put("messege", "该班课已结束");
        return state;
    }

    public HashMap<String, Object> getLesson(String classId, String username) {
        classLesson lesson = classLessonR.getLesson(Integer.parseInt(classId));
        if (lesson == null) {
            return null;
        }
        HashMap<String, Object> res = new HashMap<String, Object>();
        HashMap<String, Object> detail = new HashMap<String, Object>();
        HashMap<String, Object> dataTop = new HashMap<String, Object>();
        HashMap<String, Object> dataContent = new HashMap<String, Object>();
        dataTop.put("description", lesson.getType());
        dataTop.put("className", lesson.getClassname());
        dataTop.put("teacher", lesson.getTeachername());
        dataTop.put("time", lesson.getClasstime());
        dataContent.put("cloudBook", "未设置");
        dataContent.put("school", lesson.getCollege());
        dataContent.put("department", lesson.getMaster());
        dataContent.put("studyRequire", "暂无内容");
        dataContent.put("teachProcss", "暂无内容");
        dataContent.put("exam", "暂无内容");
        detail.put("dataTop", dataTop);
        detail.put("dataContent", dataContent);
        res.put("detail", detail);

        // 得到一个课程的每个学生的详细信息
        List<classCourseMember> list1 = courseM.getOneClassMembers(Integer.parseInt(classId));
        List<Map<String, Object>> members = new ArrayList<>();
        HashMap<String, Object> memberInfo = new HashMap<String, Object>();
        int members_count = 0;
        int location = 1;
        int rank = 0;
        int flag = 1;
        int experience = 0;
        if(list1 == null){
            return res;
        }
        if (list1.size() > 0) {
            classCourseMember classCourseM = list1.get(0);
            HashMap<String, Object> member = new HashMap<String, Object>();
            member.put("name", classCourseM.getStudentname());
            member.put("studentId", classCourseM.getStudentid());
            member.put("experience", classCourseM.getExperience());
            member.put("cloudBookStudy", 0);
            members.add(member);
            members_count += 1;
        }
        if (list1.get(0).getStudentid().equals(username)) {
            rank = 1;
            experience = list1.get(0).getExperience();
        }
        for (int i = 1; i < list1.size(); i++) {
            classCourseMember classCourseM = list1.get(i);
            if (classCourseM.getExperience() != list1.get(i - 1).getExperience()) {
                location += 1;
            }
            if ((classCourseM.getStudentid().equals(username)) && (flag == 1)) {
                rank = location;
                experience = classCourseM.getExperience();
                flag = 0;
            }

            HashMap<String, Object> member = new HashMap<String, Object>();
            member.put("name", classCourseM.getStudentname());
            member.put("studentId", classCourseM.getStudentid());
            member.put("experience", classCourseM.getExperience());
            member.put("cloudBookStudy", 0);
            members.add(member);
            members_count += 1;
        }

        memberInfo.put("number", members_count);
        memberInfo.put("members", members);
        memberInfo.put("rank", rank);
        memberInfo.put("experience", experience);
        res.put("member", memberInfo);

        // 得到一个课程的每个学生的详细任务
        List<task> list2 = taskmapper.getTask(lesson.getClassid());
       
        List<Map<String, Object>> tasks = new ArrayList<>();
        int tasks_count_out_time = 0;
        int tasks_count_in_time = 0;
        if(list2 != null){
        for (task tas : list2) {
            HashMap<String, Object> member = new HashMap<String, Object>();
            member.put("taskName", tas.getTask());
            member.put("workId", tas.getId());
            member.put("detail",tas.getGradepoint());
            // 获得已参与人数
            List<taskMemory> tasks2 = taskM.getMemoryByTaskId(Integer.toString(tas.getId()));
            if(tasks2 == null){
                member.put("number", 0);
            }else{
                member.put("number", tasks2.size());
            }
           
            member.put("experience", tas.getGrade());
            taskMemory ta = taskM.getTask(tas.getId().toString(), Integer.parseInt(username));
            if (ta == null) {
                member.put("state", "未参与");
            } else {
                member.put("state", "已参与");
            }

            Date now = new Date();
            if (now.after(tas.getLastsubmittime())) {
                member.put("timeState", "已超时");
                tasks_count_out_time += 1;
            } else {
                member.put("timeState", "进行中");
                tasks_count_in_time += 1;
            }

            tasks.add(member);
        }
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
    public ResponseData getSignType(String classId) {
        signin sig = siginR.get(classId).get(0);
        //先降序首个元素如果endtime ！=null 说明签到已结束或未开始
        //如果endtime == null && now.after(starttime)则可以签到
        if(sig.getEndtime() != null)
        {
            // return "签到已结束或老师未发布签到";
            return ResponseDataUtil.failure(404,"签到已结束或老师未发布签到");
        }
        int sigin_type = sig.getSignintype();

        Map<String ,Object> data = new HashMap<>();
        data.put("signId", sig.getId());
        data.put("sigin_type", Integer.toString(sigin_type));
        // return Integer.toString(sigin_type);
        return ResponseDataUtil.success("开始签到", data);
    }

    @Override
    public Map<String, Object> isSucced(String username, String classId, String longitude, String latitude, int role,
            String stu_shouShi, String signId) throws Exception {
        signin sig = siginM.selectByPrimaryKey(Integer.parseInt(signId));
        HashMap<String,Object> re = new HashMap<>();

        checkInHistory hist = checkInHistoryM.getOnlyHistory(sig.getId(),sig.getClassid(),username);
        if(hist != null){
            re.put("state", "false");
            re.put("msg", "您已签到，不能重复签到");
            return re;
        }
        String temp = sig.getPublisher();
        String res[] = temp.split(",");
        int flag = 0;
        
        //获取老师经纬度
        GlobalCoordinates source = new GlobalCoordinates(Double.parseDouble(res[0]), Double.parseDouble(res[1]));
        
        //ip获得经纬度
        GlobalCoordinates target = new GlobalCoordinates(Double.parseDouble(longitude), Double.parseDouble(latitude));
       
        //获得系统参数
        List<sysparameter > sys = sysparameterService.findAll();
        //获得经验值 签到距离
        int expe = 0;
        int distance = 100;
        for (sysparameter syspa : sys) {
            if(syspa.getName().equals("签到经验值"))
            {
                expe = syspa.getValue();
            }
            if(syspa.getName().equals("距离"))
            {
                distance = syspa.getValue();
            }
            
        }
        //求距离，距离大于2500米签到失败
        if(Distance.getDistanceMeter(source, target, Ellipsoid.Sphere) < distance){
            flag = 1;
        }

        Date now = new Date();
        
        //手势签到获取老师手势
        if(role == 2){
            String shouShi = res[2];
            //判断手势是否相同且签到时间是否符合
            
            if(shouShi.equals(stu_shouShi) && (now.after(sig.getStarttime()))){
                //插入学生签到记录 signId endTime username classId 
                checkInHistory his = new checkInHistory(sig.getId(),sig.getStarttime(),now,"2",username,1,classId);
                if(checkInHistoryM.insertSelective(his) == 1){
                  
                    int nowExpe = courseM.getCourse(classId, username).getExperience() + expe;
                    courseM.updateExperience(Integer.parseInt(classId),username,nowExpe);
                    re.put("state", "ok");
                    re.put("longitude", res[0]);
                    re.put("latitude", res[1]);
                    return re;
                }
                
               
            }
        }else if(role == 1){
            if((flag == 1) && (now.after(sig.getStarttime()))){
                 //插入学生签到记录 signId endTime username classId 
                 checkInHistory his = new checkInHistory(sig.getId(),sig.getStarttime(),now,"1",username,1,classId);
                 if(checkInHistoryM.insertSelective(his) == 1){
                    
                     int nowExpe = courseM.getCourse(classId, username).getExperience() + expe;
                     courseM.updateExperience(Integer.parseInt(classId),username,nowExpe);
                     re.put("state", "ok");
                     re.put("longitude", res[0]);
                     re.put("latitude", res[1]);
                     return re;
                 }
            }
        }
        re.put("state", "false");
        re.put("msg", "网络异常");
        return re;          
    }

    @Override
    public String logoutLesson(String username, String classId) {
        if(courseM.delete(username,Integer.parseInt(classId)))
            return "ok";
        return "false";
    }

    @Override
    public List<classLesson> getBanke(String number) {
        
        return classLessonR.get(number);
    }

    @Override
    public String addClass(String username,String className, String courseName, String schoolName, String departmentName,
            String semester, String studyDemand, String examDemand) {
        userInfo user = userM.findOneByNumber(username);
        classLesson course = new classLesson(null,courseName,user.getName(),Integer.parseInt(username),null,className,null,null,semester,departmentName);
        Date createTime = new Date();
        int flag = classLessonR.add(course);
        
        if(flag == 1)
        {
            
            List<classLesson> list1 = classLessonR.get(username);
            for (classLesson classLesson1 : list1) {
                if(classLesson1.getClassname().equals(courseName)   && (classLesson1.getMaster().equals(className)))
                {
                    
                    classLessonM.updateClass(classLesson1.getClassid(),schoolName,createTime);
                    return Integer.toString(classLesson1.getClassid());
                }
            }
        }
        return "false";
    }

    @Override
    /**
     * 老师获得班课详情信息
     */
    public Map<String, Object> getClassInfo(String username, String classId) {
        classLesson lesson = classLessonR.getLesson(Integer.parseInt(classId));
        if(lesson == null)
        {
            return null;
        }
        HashMap<String,Object> detail = new HashMap<String,Object>();
        HashMap<String,Object> dataTop = new HashMap<String,Object>();
        HashMap<String,Object> dataContent = new HashMap<String,Object>();
        dataTop.put("description", lesson.getMaster());
        dataTop.put("className", lesson.getClassname());
        dataTop.put("teacher", lesson.getTeachername());
        dataTop.put("semester", lesson.getClasstime());
        dataContent.put("cloudBook", "未设置");
        dataContent.put("school", lesson.getCollege());
        dataContent.put("department", lesson.getMaster());
        dataContent.put("studyRequire", "暂无内容");
        dataContent.put("teachProcss", "暂无内容");
        dataContent.put("exam", "暂无内容");
        detail.put("data", dataTop);
        detail.put("dataContent", dataContent);
        return detail;
    }

    @Override
    public String updateClass(String username, String classId, String state) {
        int flag = 0;
        if(state.equals("over")){
            classLesson les = new classLesson(Integer.parseInt(classId),state);
            flag = classLessonR.update(les);
        }else{
            classLesson les = new classLesson(Integer.parseInt(classId),state);
            flag = classLessonR.delete(les);
        }
        
        if(flag == 1)
        {
            return "ok";
        }
        return "false";
    }

    @Override
    public List<Map<String, Object>> getMembers(String classId) {
        List<classCourseMember> list1 = courseM.getOneClassMembers(Integer.parseInt(classId));
        List<Map<String,Object>> members = new ArrayList<>();
        int members_count = 0;
        for (classCourseMember classCourseM : list1) {
            HashMap<String,Object> member = new HashMap<String,Object>();
            member.put("name", classCourseM.getStudentname());
            member.put("studentId", classCourseM.getStudentid());
            member.put("experience", classCourseM.getExperience());
            member.put("cloudBookStudy", 0);
            members.add(member);
            members_count += 1;
        }
        HashMap<String,Object> count = new HashMap<String,Object>();
        count.put("number", members_count);
        members.add(count);
        return members;
    }

}