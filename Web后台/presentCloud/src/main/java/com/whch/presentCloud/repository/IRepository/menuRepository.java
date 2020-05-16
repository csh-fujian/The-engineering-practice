package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.menu;
import org.apache.ibatis.annotations.Param;

public interface menuRepository {
    public menu get(Integer id);
    public List<menu> getAll();
    public int add(menu men);
    public int update(menu men);
    public int delete(menu men);
    public int findmenuid(Integer superiormenunumber, String menuname);
    public int deletemenu(String menuname);
    int findbyname(String menuname);
}