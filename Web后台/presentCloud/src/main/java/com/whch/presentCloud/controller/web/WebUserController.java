package com.whch.presentCloud.controller.web;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.updateuser;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.classLessonMapper;
import com.whch.presentCloud.mapper.userInfoMapper;
import com.whch.presentCloud.service.IService.IUserManageService;
import com.whch.presentCloud.service.IService.Isha256Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
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
    @Autowired
    private classLessonMapper classM;
    @Autowired
    private Isha256Service sha256S;
    /**
     * 添加用户
     * @param userinfo
     * @return
     */
    @PostMapping("adduser")
    public String addUser(@RequestBody userInfo userinfo)
    {
        userInfo user = userinfo;
        user.setPassword(sha256S.getSHA256Str("88888888"));
        try{
            usermanage.addUser(user);
            return "新增成功";
        }catch (DuplicateKeyException e){
            return "新增失败，该昵称或学/工号或手机号已存在";
        }
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @RequestMapping("deleteuser")
    public String deleterole(@RequestBody userInfo user)
    {
        userInfo user1 = user;
        try{
            usermanage.delete(user);
            return "删除成功";
        }catch (DataAccessException e){
            return "删除失败，该用户与其他表外键相关";
        }
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
        try{
            usermanage.updatebyid(editUser.getUser(), editUser.getOldnumber());
            String teachername = editUser.getUser().getName();
            userInfo uu = userM.getTeacherUser(editUser.getOldnumber());
            String oldteachername = uu.getName();
            classM.setname(teachername, oldteachername);
            return "编辑成功";
        }catch (DuplicateKeyException e){
            return "编辑失败，该学/工号或昵称或手机号已存在";
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
        return totalSize;
    }

    /**
     * 重置用户密码
     * @param number
     */
    @RequestMapping("setpassword/{number}")
    public void setpassword(@PathVariable String number){
        String password = sha256S.getSHA256Str("88888888");
        usermanage.setpassword(password, number);
    }

    @GetMapping("multiquery")
    public List<userInfo> multiquery(@RequestParam String number, @RequestParam String role, @RequestParam String school, @RequestParam String department)
    {
        return usermanage.multiquery(number, role, school, department);
    }
}
