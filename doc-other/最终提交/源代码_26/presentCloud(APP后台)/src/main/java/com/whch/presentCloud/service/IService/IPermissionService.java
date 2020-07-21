package com.whch.presentCloud.service.IService;

import com.whch.presentCloud.entity.container;
import com.whch.presentCloud.entity.permission;

import java.util.List;

public interface IPermissionService {

    public List<container> findAll(String rolename);

    public container getChildList(List<permission> list, int pId, container c, String rolename);

    public boolean ifChilds(List<permission> list,int pId);

    public int addpermission(String role, List<String> menus);
}
