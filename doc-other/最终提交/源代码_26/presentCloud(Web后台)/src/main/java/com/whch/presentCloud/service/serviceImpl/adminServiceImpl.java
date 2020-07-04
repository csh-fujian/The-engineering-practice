package com.whch.presentCloud.service.serviceImpl;

import com.whch.presentCloud.entity.admin;
import com.whch.presentCloud.mapper.adminMapper;
import com.whch.presentCloud.mapper.classCourseMemberMapper;
import com.whch.presentCloud.service.IService.IAdminService;
import com.whch.presentCloud.service.IService.Isha256Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class adminServiceImpl implements IAdminService {

    @Autowired
    private adminMapper adminM;
    @Autowired
    private classCourseMemberMapper courseM;
    @Autowired
    private Isha256Service sha256S;

    @Override
    public int addadmin(admin Admin) {
        admin Admin1 = new admin();
        Admin1.setName(Admin.getName());
        Admin1.setAccount("2");
        Admin1.setPassword(sha256S.getSHA256Str("88888888"));
        Admin1.setPhone(Admin.getPhone());
        return adminM.insertSelective(Admin1);
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
