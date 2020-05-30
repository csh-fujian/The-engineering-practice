package com.whch.presentCloud.service.IService;

import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;

public interface IClassManageService {

	List<classCourseMember> getLessons(String number);

	public boolean addCourse(classLesson Class);

	public boolean deleteCourse(Integer classid);

	public List<classLesson> find(String teachername);

	public List<classLesson> findAll();

	public boolean updateCourse(classLesson Class);

	List<Map> getCourse(String classId);

	Map<String, Object> getLesson(String classId, String username);

}