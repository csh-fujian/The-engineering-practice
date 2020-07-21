package com.whch.presentCloud.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.classCourseMemberMapper;
import com.whch.presentCloud.mapper.directoryDataMapper;
import com.whch.presentCloud.mapper.userInfoMapper;
import com.whch.presentCloud.repository.IRepository.userInfoRepository;
import com.whch.presentCloud.service.IService.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class userManageServiceImpl implements IUserManageService {

    @Autowired
    private userInfoRepository userRepo;

    @Autowired
    private userInfoMapper userMapper;
    @Autowired
    private classCourseMemberMapper courseM;
    @Autowired
    private directoryDataMapper dictionaryM;

    @Override
    public List<userInfo> getAllUser() {
        return userRepo.getAll();
    }

    @Override
    public String addUser(userInfo user) {
        if (userRepo.add(user) == 1) {
            return "ok";
        }
        return "false";
    }

    @Override
    public int delete(userInfo user) {
        return userRepo.delete(user);
    }

    @Override
    public String updatebyid(userInfo user, String number) {
        if (userRepo.update(user, number) == 1) {
            return "ok";
        }
        return "false";
    }

    @Override
    public Page<userInfo> findByPaging(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<userInfo> userList = userMapper.findByPaging();
        return userList;
    }

    @Override
    public List<userInfo> multiquery(String number, String role, String school, String department) {
        return userRepo.multiquery(number, role, school, department);
    }

    @Override
    public userInfo getUser(String username) {

        userInfo user = userMapper.findOneUser(username);
        return user;
    }

    @Override
    public Map<String, Object> getUserInfo(String username) {
        userInfo user = userMapper.findOneByNumber(username);
        if(user == null){
            return null;
        }
        Map<String,Object> res = new HashMap<>();
        res.put("name", user.getName());
        res.put("nickName", user.getNickname());
        SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月");
        if(user.getBirthday() != null)
        {
            res.put("birthtime", formater.format(user.getBirthday()).substring(0, 8));
        }
//        res.put("birthtime", user.getBirthday());
        res.put("sex", dictionaryM.findByValue(user.getSex()));
        res.put("femaleValue", dictionaryM.findbykey("female"));
        res.put("maleValue", dictionaryM.findbykey("male"));
        res.put("school", user.getSchool());
        res.put("department", user.getDepartment());
        res.put("role", user.getRole());
        res.put("studentId", user.getNumber());
        //获得所有班课总的经验值
        List<classCourseMember> classes = courseM.get(user.getNumber());
        int experience = 0;
        for (classCourseMember member : classes) {
            experience += member.getExperience();
        }
        res.put("experience", experience);
        return res;
    }
}
