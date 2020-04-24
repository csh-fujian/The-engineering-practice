package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.admin;

public interface adminRepository {
    public admin get(String number, String password);
    public List<admin> getAll();
    public int add(admin adm);
    public int update(admin adm);
    public int delete(admin adm);

}