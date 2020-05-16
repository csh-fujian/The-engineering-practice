package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.menu;
import com.whch.presentCloud.mapper.menuMapper;
import com.whch.presentCloud.repository.IRepository.menuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class menuRepositoryImpl implements menuRepository {
    @Autowired
    private menuMapper menuM;
    @Override
    public menu get(final Integer id) {
        // TODO Auto-generated method stub
        return menuM.selectByPrimaryKey(id);
    }

    @Override
    public List<menu> getAll() {
        // TODO Auto-generated method stub
        return menuM.getAll();
    }

    @Override
    public int add(final menu men) {
        // TODO Auto-generated method stub
        return menuM.insertSelective(men);
    }

    @Override
    public int update(final menu men) {
        // TODO Auto-generated method stub
        return menuM.updateByPrimaryKeySelective(men);
    }

    @Override
    public int delete(final menu men) {
        // TODO Auto-generated method stub
        return menuM.deleteByPrimaryKey(men.getId());
    }

    @Override
    public int findmenuid(Integer superiormenunumber, String menuname) {
        return menuM.findmenuid(superiormenunumber, menuname);
    }

    @Override
    public int deletemenu(String menuname) {
        return menuM.deletemenu(menuname);
    }

    @Override
    public int findbyname(String menuname) {
        return menuM.findbyname(menuname);
    }

}