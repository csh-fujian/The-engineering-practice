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

	Map<String, Object> getLesson(String classId, String username);

	String getSignType(String classId);

	boolean isSucced(String username, String classId, String ip, int i, String string) throws Exception;

	String logoutLesson(String username, String classId);

}