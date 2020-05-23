package com.whch.presentCloud.controller.app;

import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.service.IService.IClassManageService;
import com.whch.presentCloud.utils.IPUtils;

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

    @RequestMapping("one-class")
    public Map<String,Object> getClassInfo(@RequestParam("classId")String classId,@RequestParam("username")String username)
    {
        Map<String,Object> res = classManageService.getLesson(classId,username);
        return res;
    }

    /**
     * 发起签到
     * @param classId
     * @return
     */
    @RequestMapping("/participate")
    public String participate(@RequestParam("classId")String classId)
    {
        
        return classManageService.getSignType(classId);
    }

    /**
     * 一键签到
     * @param username 学号
     * @param ip
     * @return
     * @throws Exception
     */
    @RequestMapping("/participate/1")
    public result getWeiDu(@RequestParam("username")String username,@RequestParam("classId")String classId, @RequestParam("ip") String ip) throws Exception {
        result res = new result();
        Double dou[] = IPUtils.getJingWeiDu(ip);
        if(classManageService.isSucced(username,classId,ip,1,"")){
            res.setState("ok");
            
        }else{
            res.setState("false");
        }
        res.setMap("jingWeiDu", dou);
        return res;
    }
}