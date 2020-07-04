package com.whch.presentCloud.service.IService;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.role;

import java.util.List;

public interface IRoleManageService {

    public List<role> getAllRole();

    public int addRole(role ro);

    public int delete(role ro);

    public Page<role> findByPaging(Integer pageNum, Integer pageSize);

}
