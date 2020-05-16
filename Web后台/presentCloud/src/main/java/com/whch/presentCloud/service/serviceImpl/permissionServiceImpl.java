package com.whch.presentCloud.service.serviceImpl;

import com.whch.presentCloud.entity.container;
import com.whch.presentCloud.entity.permission;
import com.whch.presentCloud.entity.rolemenu;
import com.whch.presentCloud.repository.IRepository.permissionRepository;
import com.whch.presentCloud.service.IService.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class permissionServiceImpl implements IPermissionService {

    @Autowired
    private permissionRepository permR;

    @Override
    public List<container> findAll(String rolename) {

        List<permission> list1 = permR.getAll();

        List<container> resultList = new ArrayList<>();

        for (permission m : list1) {
            if (m.getSuperiormenunumber() == 0) {//父级菜单开始添加
                container c = new container();
                c.setName(m.getMenuname());
                if (permR.findone(rolename, m.getMenuname()) != null){
                    c.setState("checked");
                }
                else {
                    c.setState("unchecked");
                }
                c.setLayer(m.getIsmenu());
                if (ifChilds(list1, m.getId())) {//存在子集
                    c = getChildList(list1, m.getId(), c, rolename);
                }
                resultList.add(c);
            }
        }
        return resultList;
    }


    //获取父id下的子集合
    public container getChildList(List<permission> list, int pId, container c, String rolename) {

        List<container> sublist = new ArrayList<container>();

        for (permission m : list) {
            if (m.getSuperiormenunumber()==pId) {//查询下级菜单
                container co = new container();
                co.setName(m.getMenuname());
                if (permR.findone(rolename, m.getMenuname()) != null){
                    co.setState("checked");
                }
                else {
                    co.setState("unchecked");
                }
                co.setLayer(m.getIsmenu());
                if (ifChilds(list, m.getId())) {
                    co = getChildList(list, m.getId(), co, rolename);
                }
                sublist.add(co);
            }
        }
        c.setSub(sublist);

        return c;
    }

    //判断是否存在子集
    public boolean ifChilds(List<permission> list,int pId) {
        boolean flag = false;
        for (permission m : list) {
            if (m.getSuperiormenunumber()==pId) {
                flag=true;
                break;
            }
        }
        return flag;
    }

    @Override
    public int addpermission(String role, List<String> menus) {
        for (String m : menus)
        {
            permR.addpermission(role, m);
        }
        return 1;
    }
}

