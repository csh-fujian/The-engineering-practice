package com.whch.presentCloud.controller.web;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.role;
import com.whch.presentCloud.service.IService.IRoleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webrole")
public class WebUserRoleController {

    @Autowired
    private IRoleManageService roleManageService;

    /**
     * 添加角色
     * @param ro
     * @return
     */
    @PostMapping("addrole")
    public int addrole(@RequestBody role ro)
    {
        return roleManageService.addRole(ro);
    }

    /**
     * 删除角色
     * @param ro
     * @return
     */
    @DeleteMapping("deleterole")
    public int deleterole(@RequestBody role ro)
    {
        return roleManageService.delete(ro);
    }

    /**
     * 查询所有角色
     * @return
     */
    @GetMapping("findrole")
    public List<role> findrole()
    {
        List<role> roles = roleManageService.getAllRole();
        int i = 0;
        for(role r : roles)
        {
            i++;
            r.setId(i);
        }
        return roles;
    }

    /**
     * 角色管理的分页功能
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("pagefind")
    public Page<role> findRolebyPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize)
    {
        return roleManageService.findByPaging(pageNum, pageSize);
    }

}
