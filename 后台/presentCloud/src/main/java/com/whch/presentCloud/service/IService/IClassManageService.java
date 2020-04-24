package com.whch.presentCloud.service.IService;

import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;

public interface IClassManageService {

	List<classCourseMember> getLessons(String number);

	String addCourse(String classId, String studentId);

	List<Map> getCourse(String classId);

	List<Map<String, Object>> getLesson(String classId, String username);

}