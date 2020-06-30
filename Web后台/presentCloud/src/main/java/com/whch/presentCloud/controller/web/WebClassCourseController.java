package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.mapper.classCourseMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webcourse")
public class WebClassCourseController {
    @Autowired
    private classCourseMemberMapper courseM;

    @GetMapping("find/{id}")
    public List<classCourseMember> findbyid(@PathVariable int classid){
        return courseM.getOneClassMembers(classid);
    }

    @RequestMapping("delete")
    public String deletestu(@RequestBody classCourseMember coursemember){
        int classid = coursemember.getClassid();
        String studentid = coursemember.getStudentid();
        try{
            courseM.deletestu(classid, studentid);
            return "删除成功";
        }catch (DataAccessException e){
            return "删除失败，这条数据与其他表外键相关";
        }
    }

}
