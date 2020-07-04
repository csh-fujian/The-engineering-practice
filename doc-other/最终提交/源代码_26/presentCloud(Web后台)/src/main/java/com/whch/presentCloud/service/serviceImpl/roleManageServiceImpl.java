package com.whch.presentCloud.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.role;
import com.whch.presentCloud.mapper.roleMapper;
import com.whch.presentCloud.repository.IRepository.roleRepository;
import com.whch.presentCloud.service.IService.IRoleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.awt.print.Pageable;
import java.util.List;
@Service
public class roleManageServiceImpl implements IRoleManageService {

    @Autowired
    private roleRepository roleRepo;

    @Autowired
    private roleMapper roleMapper;

    @Override
    public List<role> getAllRole() {
        return roleRepo.getAll();
    }

    @Override
    public int addRole(role ro) {
        roleRepo.add(ro);
        return 0;
    }

    @Override
    public int delete(role ro) {
        return roleRepo.delete(ro);
    }


    @Override
    public Page<role> findByPaging(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<role> roleList = roleMapper.findByPaging();
        return roleList;
    }

}
