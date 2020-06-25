package com.whch.presentCloud.controller.web;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.updateuser;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.userInfoMapper;
import com.whch.presentCloud.service.IService.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("webuser")
public class WebUserController {

    @Autowired
    private IUserManageService usermanage;
    @Autowired
    private userInfoMapper userM;

    /**
     * 添加用户
     * @param userinfo
     * @return
     */
    @PostMapping("adduser")
    public String addUser(@RequestBody userInfo userinfo)
    {
        userInfo user = userinfo;
        user.setPassword("88888888");
        String nickname = user.getNickname();
        List<userInfo> list1 = userM.find1(nickname);
        int i = 0;
        for(userInfo u : list1)
        {
            if (u.getNickname().equals(nickname)){
                i++;
            }
        }
        if(i == 0){
            if(usermanage.addUser(user)==0){
                return "新增成功";
            }
            else {
                return "新增失败，原因未知";
            }
        }
        else {
            return "新增失败，该昵称已存在";
        }
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @RequestMapping("deleteuser")
    public int deleterole(@RequestBody userInfo user)
    {
        userInfo user1 = user;
        return usermanage.delete(user);
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("finduser")
    public List<userInfo> finduser(HttpServletRequest request)
    {
        return usermanage.getAllUser();
    }

    /**
     * 修改用户信息
     * @param editUser
     * @return
     */
    @RequestMapping("updateuser")
    public String updateuser(@RequestBody updateuser editUser){
        userInfo user1 = editUser.getUser();
        String nickname = user1.getNickname();
        List<userInfo> list1 = userM.find1(nickname);
        int i = 0;
        for(userInfo u : list1)
        {
            if (u.getNickname().equals(nickname)){
                i++;
            }
        }
        if(i == 0){
            if(usermanage.updatebyid(editUser.getUser(), editUser.getOldnumber())==1){
                return "编辑成功";
            }
            else {
                return "编辑失败，该学/工号已存在";
            }
        }
        else {
            return "编辑失败，该昵称已存在";
        }
    }

    /**
     * 用户管理分页功能
     * @param pageNum
     * @return
     */
    @GetMapping("pagefind/{pageNum}")
    public Page<userInfo> findUserbyPage(@PathVariable Integer pageNum)
    {
        return usermanage.findByPaging(pageNum, 8);
    }

    @GetMapping("totalSize")
    public int totalSize()
    {
        List<userInfo> list1 = usermanage.getAllUser();
        int totalSize = 0;
        for(userInfo u : list1)
        {
            totalSize++;
        }
        System.out.println(totalSize);
        return totalSize;
    }

    /**
     * 重置用户密码
     * @param number
     */
    @RequestMapping("setpassword/{number}")
    public void setpassword(@PathVariable String number){
        String password = "88888888";
        usermanage.setpassword(password, number);
    }

    @GetMapping("multiquery")
    public List<userInfo> multiquery(@RequestParam String number, @RequestParam String role, @RequestParam String school, @RequestParam String department)
    {
        return usermanage.multiquery(number, role, school, department);
    }
}
