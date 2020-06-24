package com.whch.presentCloud.service.IService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;

public interface IClassManageService {

	List<classCourseMember> getLessons(String number);

	String addCourse(String classId, String studentId);

	HashMap<String,Object> getCourse(String classId);

	Map<String, Object> getLesson(String classId, String username);

	String getSignType(String classId);

	boolean isSucced(String username, String classId, String ip, int i, String string) throws Exception;

	String logoutLesson(String username, String classId);

	List<classLesson> getBanke(String number);

//    void getCourseseInfo(Integer classid);
}