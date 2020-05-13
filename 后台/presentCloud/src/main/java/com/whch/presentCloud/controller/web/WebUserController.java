package com.whch.presentCloud.controller.web;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.role;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.service.IService.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webuser")
public class WebUserController {

    @Autowired
    private IUserManageService usermanage;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("adduser")
    public int addUser(@RequestBody userInfo user)
    {
        return usermanage.addUser(user);
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @DeleteMapping("deleteuser")
    public int deleterole(@RequestBody userInfo user)
    {
        return usermanage.delete(user);
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("finduser")
    public List<userInfo> finduser()
    {
        return usermanage.getAllUser();
    }

    /**
     * 修改某一用户的信息
     * @param user
     * @return
     */
    @PutMapping("updateuser")
    public int updateuser(@RequestBody userInfo user, @RequestParam Integer id){
        return usermanage.updatebyid(user, id);
    }

    /**
     * 用户管理的分页功能
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("pagefind")
    public Page<userInfo> findUserbyPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize)
    {
        return usermanage.findByPaging(pageNum, pageSize);
    }

    @GetMapping("multiquery")
    public List<userInfo> multiquery(@RequestParam Integer id, @RequestParam String role, @RequestParam String school, @RequestParam String department)
    {
        return usermanage.multiquery(id, role, school, department);
    }
}
