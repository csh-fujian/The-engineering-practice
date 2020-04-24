package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.userInfoMapper;
import com.whch.presentCloud.repository.IRepository.userInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class userInfoRepositoryImpl implements userInfoRepository {
    @Autowired
    private userInfoMapper userInfoM;

    @Override
    public userInfo get(String name) {

        return userInfoM.findOne(name);
    }

    @Override
    public List<userInfo> getAll() {
       
        return userInfoM.getAll();
    }

    @Override
    public int add(userInfo UserInfo) {
        
        return userInfoM.insertSelective(UserInfo);
    }

    @Override
    public int update(userInfo UserInfo) {
       
        return userInfoM.updateByPrimaryKeySelective(UserInfo);
    }

    @Override
    public int delete(userInfo UserInfo) {
        return userInfoM.deleteByPrimaryKey(UserInfo.getId());
    }

    @Override
<<<<<<< HEAD:后台/presentCloud/src/main/java/com/whch/presentCloud/repository/repositoryImpl/userInfoRepositoryImpl.java
    public userInfo get(String phone) {
        
        return userInfoM.getUser(phone);
    }

=======
    public Integer login(userInfo user){
        return userInfoM.login(user);
    }
>>>>>>> 0236528e59ea8e265af16299a78997b50d35f252:presentCloud/src/main/java/com/whch/presentCloud/repository/repositoryImpl/userInfoRepositoryImpl.java
}