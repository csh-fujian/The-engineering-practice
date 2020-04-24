package com.whch.presentCloud.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.mapper.classCourseMemberMapper;
import com.whch.presentCloud.repository.IRepository.classLessonRepository;
import com.whch.presentCloud.service.IService.IClassManageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class classManageServiceImpl implements IClassManageService {

    @Autowired
    private classLessonRepository classLessonR;
    @Autowired
    private classCourseMemberMapper courseM;

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
        classLesson lesson = classLessonR.getLesson(Integer.parseInt(classId))
        if(flag == 0)
        {
            return "false";
        }
        return "true";
    }

    @Override
    public List<Map> getCourse(String classId) {
        classLesson lesson = classLessonR.getLesson(Integer.parseInt(classId))
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

}