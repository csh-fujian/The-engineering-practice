package com.whch.presentCloud.repository.IRepository;

import com.whch.presentCloud.entity.permission;
import com.whch.presentCloud.entity.rolemenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface permissionRepository {
    public permission get(Integer id);
    public List<permission> getAll();
    public int add(permission perm);
    public int update(permission perm);
    public int delete(permission perm);
    public rolemenu findone(String rolename, String menu);
    public int findmenuid(Integer superiormenunumber, String menuname);
    public int deletemenu(String menuname);
    public int addpermission(String role, String menu);
    int findbyname(String menuname);
}
