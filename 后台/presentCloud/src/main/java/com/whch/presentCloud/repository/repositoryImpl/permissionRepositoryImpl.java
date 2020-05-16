package com.whch.presentCloud.repository.repositoryImpl;

import com.whch.presentCloud.entity.permission;
import com.whch.presentCloud.entity.rolemenu;
import com.whch.presentCloud.mapper.permissionMapper;
import com.whch.presentCloud.repository.IRepository.permissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class permissionRepositoryImpl implements permissionRepository {

    @Autowired
    private permissionMapper permM;

    @Override
    public permission get(Integer id) {
        return permM.selectByPrimaryKey(id);
    }

    @Override
    public List<permission> getAll() {
        return permM.getAll();
    }

    @Override
    public int add(permission perm) {
        return permM.insert(perm);
    }

    @Override
    public int update(permission perm) {
        return permM.updateByPrimaryKeySelective(perm);
    }

    @Override
    public int delete(permission perm) {
        return permM.deleteByPrimaryKey(perm.getId());
    }

    @Override
    public rolemenu findone(String rolename, String menu) {
        return permM.findone(rolename, menu);
    }

    @Override
    public int findmenuid(Integer superiormenunumber, String menuname) {
        return permM.findmenuid(superiormenunumber, menuname);
    }

    @Override
    public int deletemenu(String menuname) {
        return permM.deletemenu(menuname);
    }

    @Override
    public int addpermission(String role, String menu) {
        return permM.addpermisson(role, menu);
    }

    @Override
    public int findbyname(String menuname) {
        return permM.findbyname(menuname);
    }
}
