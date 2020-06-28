package com.whch.presentCloud.service.IService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.ResponseData;
import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;

public interface IClassManageService {

	List<classCourseMember> getLessons(String number);

	String addCourse(String classId, String studentId);

	HashMap<String,Object> getCourse(String classId);

	Map<String, Object> getLesson(String classId, String username);

	ResponseData getSignType(String classId);

	boolean isSucced(String username, String classId, String ip, int i, String string) throws Exception;

	String logoutLesson(String username, String classId);

	List<classLesson> getBanke(String number);

	String addClass( String username,String className, String courseName, String schoolName, String departmentName, String semester,
			String studyDemand, String examDemand);

	Map<String, Object> getClassInfo(String username, String classId);

	String updateClass(String username, String classId, String state);

	List<Map<String, Object>> getMembers(String classId);


//    void getCourseseInfo(Integer classid);
}