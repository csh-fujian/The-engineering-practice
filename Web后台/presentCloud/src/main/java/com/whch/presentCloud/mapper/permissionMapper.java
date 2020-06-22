package com.whch.presentCloud.mapper;

import com.whch.presentCloud.entity.permission;
import com.whch.presentCloud.entity.rolemenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface permissionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(permission record);

    int insertSelective(permission record);

    permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(permission record);

    int updateByPrimaryKey(permission record);

    @Select("select * from permission")
    List<permission> getAll();

    @Select("select * from rolemenu where role = #{rolename} and menu = #{menu}")
    rolemenu findone(@Param("rolename") String rolename, @Param("menu") String menu);

    @Select("select id from permission where SuperiorMenuNumber = #{superiormenunumber} and menuname = #{menuname}")
    int findmenuid(@Param("superiormenunumber") Integer superiormenunumber, @Param("menuname")  String menuname);

    @Delete("delete from permission where menuname = #{menuname}")
    int deletemenu(@Param("menuname") String menuname);

    @Delete("delete from rolemenu where role = #{role}")
    int deleterolemenu(@Param("role") String role);

    @Insert("insert into rolemenu(role, menu) values (#{role}, #{menu})")
    int addpermisson(@Param("role") String role, @Param("menu") String menu);

    @Select("select id from permission where menuname = #{menuname}")
    int findbyname(@Param("menuname") String menuname);
}
