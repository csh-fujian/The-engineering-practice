package com.whch.presentCloud.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.task;
import com.whch.presentCloud.entity.taskMemory;
import com.whch.presentCloud.mapper.classCourseMemberMapper;
import com.whch.presentCloud.repository.IRepository.classLessonRepository;
import com.whch.presentCloud.repository.IRepository.taskMemoryRepository;
import com.whch.presentCloud.repository.IRepository.taskRepository;
import com.whch.presentCloud.service.IService.IClassManageService;

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

    @Override
    public List<classCourseMember> getLessons(String number) {

        return courseM.get(number);
    }

    @Override
    public String addCourse(String classId, String studentId) {
        // TODO Auto-generated method stub
        classCourseMember course1 = new classCourseMember();
        course1.setClassid(Integer.parseInt(classId));
        course1.setStudentid(studentId);
        int flag = courseM.insertSelective(course1);
        classLesson lesson = classLessonR.getLesson(Integer.parseInt(classId));
        if(flag == 0)
        {
            return "false";
        }
        return "true";
    }

    @Override
    public List<Map> getCourse(String classId) {
        classLesson lesson = classLessonR.getLesson(Integer.parseInt(classId));
        if(lesson == null)
        {
            return null;
        }
        List<Map> list = new ArrayList<>();
        HashMap h = new HashMap<String,Object>();
        h.put("teacher", lesson.getTeachername());
        h.put("classId",lesson.getClassid());
        h.put("school", lesson.getCollege());
        h.put("department", lesson.getMaster());
        list.add(h);
        return list;
    }

    @Override
    public HashMap<String, Object> getLesson(String classId, String username) {
        classLesson lesson = classLessonR.getLesson(Integer.parseInt(classId));
        if(lesson == null)
        {
            return null;
        }
        HashMap<String,Object> res = new HashMap<String,Object>();
        HashMap<String,Object> detail = new HashMap<String,Object>();
        HashMap<String,Object> dataTop = new HashMap<String,Object>();
        HashMap<String,Object> dataContent = new HashMap<String,Object>();
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

        List<classCourseMember> list1 = courseM.getOneClassMembers(Integer.parseInt(classId));
        List<Map<String,Object>> members = new ArrayList<>();
        for (classCourseMember classCourseM : list1) {
            HashMap<String,Object> member = new HashMap<String,Object>();
            member.put("name", classCourseM.getStudentname());
            member.put("studentId", classCourseM.getStudentid());
            member.put("experience", classCourseM.getExperience());
            member.put("cloudBookStudy", 0);
            members.add(member);
        }
        res.put("members", members);

        List<taskMemory> list2 = taskM.get(Integer.parseInt(username));
        List<Map<String,Object>> tasks = new ArrayList<>();
        for (taskMemory tas : list2) {
            HashMap<String,Object> member = new HashMap<String,Object>();
            member.put("taskName", tas.getTask());
            member.put("number", 150);
            member.put("experience", tas.getGrade());
            member.put("state", tas.getIsparticipate());
            member.put("timeState", tas.getIsparticipate());
            tasks.add(member);
        }
        res.put("tasks", tasks);
        return res;
    }

}