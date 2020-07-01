package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.mapper.classCourseMemberMapper;
import com.whch.presentCloud.service.IService.Isha256Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webcourse")
public class WebClassCourseController {
    @Autowired
    private classCourseMemberMapper courseM;
    @Autowired
    private Isha256Service sha256S;

    @GetMapping("find/{classid}")
    public List<classCourseMember> findbyid(@PathVariable Integer classid){
        return courseM.getOneClassMembers(classid);
    }

    @RequestMapping("delete")
    public String deletestu(@RequestBody classCourseMember coursemember){
        System.out.println(coursemember.getStudentid());
        System.out.println(coursemember.getClassid());
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
