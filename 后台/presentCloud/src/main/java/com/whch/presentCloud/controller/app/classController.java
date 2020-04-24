package com.whch.presentCloud.controller.app;

import java.util.List;
import java.util.Map;

import com.whch.presentCloud.service.IService.IClassManageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class classController {
    @Autowired
    private IClassManageService classManageService;

    /**
     * 输入班级号获取班课详情
     * @param classId
     * @param studentId
     * @return
     */
    @RequestMapping("/join-class")
    public List<Map> joinClass(@RequestParam("classId")String classId , @RequestParam("username")String studentId)

    {
        List<Map> resul = classManageService.getCourse(classId);
        return resul;
    }

    /**
     * 加入班课
     * @param classId
     * @param studentId
     * @return
     */
    @RequestMapping("/join-class/join-in")
    public String joinIn(@RequestParam("classId")String classId , @RequestParam("username")String studentId)
    {
        String resul = classManageService.addCourse(classId,studentId);
        return resul;
    }

    
}