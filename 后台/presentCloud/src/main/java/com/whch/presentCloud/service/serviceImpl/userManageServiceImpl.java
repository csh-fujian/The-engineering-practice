package com.whch.presentCloud.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.userInfoMapper;
import com.whch.presentCloud.repository.IRepository.userInfoRepository;
import com.whch.presentCloud.service.IService.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userManageServiceImpl implements IUserManageService{

    @Autowired
    private userInfoRepository userRepo;

    @Autowired
    private userInfoMapper userMapper;

    @Override
    public List<userInfo> getAllUser() {
        return userRepo.getAll();
    }

    @Override
    public int addUser(userInfo user) {
        userRepo.add(user);
        return 0;
    }

    @Override
    public int delete(userInfo user) {
        return userRepo.delete(user);
    }

    @Override
    public int updatebyid(userInfo user, String number) {
        return userRepo.update(user, number);
    }

    @Override
    public Page<userInfo> findByPaging(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<userInfo> userList = userMapper.findByPaging();
        return userList;
    }

    @Override
    public List<userInfo> multiquery(String number, String role, String school, String department) {
        return userRepo.multiquery(number, role, school, department);
    }

    @Override
    public userInfo getUser(String username) {
       
        return userMapper.findOneUser(username);
    }
}
