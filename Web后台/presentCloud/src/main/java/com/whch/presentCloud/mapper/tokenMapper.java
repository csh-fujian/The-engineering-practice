package com.whch.presentCloud.mapper;

import com.whch.presentCloud.entity.token;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface tokenMapper {

    @Insert("insert into token(tokenId, userId, token, buildTime) values{#{tokenId}, #{userId}, #{token}, #{buildTime})")
    void Insert(token Token);

    @Delete("delete from token where tokenId = {tokenId}")
    void delete(long tokenId);

    @Update("update token set tokenId=#{tokenId}, userId=#{userId}, token=#{token}, buildTime=#{buildTime} where tokenId=#{tokenId}")
    void update(token Token);

    @Select("select * from token where tokenId=#{tokenId}")
    token getById(long tokenId);

    @Select("select * from token where userId=#{userId}")
    token getByUserId(long userId);
}
