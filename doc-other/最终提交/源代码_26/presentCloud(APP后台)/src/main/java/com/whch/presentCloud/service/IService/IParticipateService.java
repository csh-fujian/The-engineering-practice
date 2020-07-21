package com.whch.presentCloud.service.IService;

import java.util.List;
import java.util.Map;

/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-06-26 21:29:30
 * @LastEditors: whc
 * @LastEditTime: 2020-06-28 10:44:30
 */ 
public interface IParticipateService {

	List<Map<String, Object>> getSignHistory(String classId);

	String insertSign(String username, String classId, String longitude, String latitude, String type, String posenumber);

	String updateSign(String signId, String type);
    
}
