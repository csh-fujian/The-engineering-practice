package com.whch.presentCloud.service.serviceImpl;

import com.whch.presentCloud.entity.admin;
import com.whch.presentCloud.mapper.adminMapper;
import com.whch.presentCloud.mapper.classCourseMemberMapper;
import com.whch.presentCloud.service.IService.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class adminServiceImpl implements IAdminService {

    @Autowired
    private adminMapper adminM;

    @Autowired
    private classCourseMemberMapper courseM;
    @Override
    public int addadmin(String name) {
        admin Admin = new admin();
        Admin.setName(name);
        Admin.setAccount("2");
        Admin.setPassword("88888888");
        return adminM.insertSelective(Admin);
    }

    @Override
    public List<admin> find() {
        return adminM.findAll("2");
    }

    @Override
    public int delete(String name) {
        return adminM.deleteadmin(name);
    }

    @Override
    public int update(String password, String name) {
        return adminM.updateadmin(password, name);
    }

}
