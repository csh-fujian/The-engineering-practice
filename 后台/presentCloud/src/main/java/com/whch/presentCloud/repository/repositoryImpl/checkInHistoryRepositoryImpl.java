package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.checkInHistory;
import com.whch.presentCloud.mapper.checkInHistoryMapper;
import com.whch.presentCloud.repository.IRepository.checkInHistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class checkInHistoryRepositoryImpl implements checkInHistoryRepository {
    @Autowired
    private checkInHistoryMapper checkM;
    @Override
    public List<checkInHistory> get(String number) {
        // TODO Auto-generated method stub
        return checkM.findOne(number);
    }

    @Override
    public List<checkInHistory> getAll() {
        // TODO Auto-generated method stub
        return checkM.getAll();
    }

    @Override
    public int add(checkInHistory checkInH) {
        // TODO Auto-generated method stub
        return checkM.insertSelective(checkInH);
    }

    @Override
    public int update(checkInHistory checkInH) {
        // TODO Auto-generated method stub
        return checkM.updateByPrimaryKeySelective(checkInH);
    }

    @Override
    public int delete(checkInHistory checkInH) {
        // TODO Auto-generated method stub
        return checkM.deleteByPrimaryKey(checkInH.getId());
    }

}