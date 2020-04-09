package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.experience;
import com.whch.presentCloud.mapper.experienceMapper;
import com.whch.presentCloud.repository.IRepository.experienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class experienceRepositoryImpl implements experienceRepository {
    @Autowired
    private experienceMapper expM;
    @Override
    public experience get(String studentId, Integer classId) {
        // TODO Auto-generated method stub
        return expM.findOne(studentId,classId);
    }

    @Override
    public List<experience> getAll() {
        // TODO Auto-generated method stub
        return expM.getAll();
    }

    @Override
    public int add(experience exper) {
        // TODO Auto-generated method stub
        return expM.insertSelective(exper);
    }

    @Override
    public int update(experience exper) {
        // TODO Auto-generated method stub
        return expM.updateByPrimaryKeySelective(exper);
    }

    @Override
    public int delete(experience exper) {
        // TODO Auto-generated method stub
        return expM.deleteByPrimaryKey(exper.getStudentid());
    }

}