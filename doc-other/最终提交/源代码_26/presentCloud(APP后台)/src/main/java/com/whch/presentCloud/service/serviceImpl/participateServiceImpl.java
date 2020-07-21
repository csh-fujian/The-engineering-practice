package com.whch.presentCloud.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.checkInHistory;
import com.whch.presentCloud.entity.signin;
import com.whch.presentCloud.mapper.checkInHistoryMapper;
import com.whch.presentCloud.mapper.classCourseMemberMapper;
import com.whch.presentCloud.mapper.signinMapper;
import com.whch.presentCloud.repository.IRepository.classLessonRepository;
import com.whch.presentCloud.service.IService.IParticipateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-06-26 21:30:05
 * @LastEditors: whc
 * @LastEditTime: 2020-06-26 22:19:19
 */
@Service
public class participateServiceImpl implements IParticipateService {

    @Autowired
    private signinMapper siginM;
    @Autowired
    private checkInHistoryMapper checkInHistoryM;
    @Autowired
    private classLessonRepository classsLessonR;
    @Autowired
    private classCourseMemberMapper courseM;
    @Override
    public List<Map<String, Object>> getSignHistory(String classId) {
        List<signin> list1 = siginM.findById(Integer.parseInt(classId));
        List<Map<String, Object>> history = new ArrayList<>();
        for (signin sign : list1) {
            Map<String, Object> info = new HashMap<>();
            if(sign.getSignintype() == 1){
                info.put("signType", "一键签到" );
            }else{
                info.put("signType", "手势签到");
            }
            Date time = sign.getStarttime();
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            info.put("signDate", formatter1.format(time)) ;
            Calendar c = Calendar.getInstance();
            c.setTime(time);
            int week = c.get(Calendar.DAY_OF_WEEK) - 1;
            if(week != 0){
                info.put("signWeek", "星期"+(week));
            }else{
                info.put("signWeek", "星期日");
            }
           
            SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
            info.put("signTime", formatter2.format(time));
            List<checkInHistory> hist = checkInHistoryM.getHistories(sign.getId());
            info.put("statistic", hist.size() +"/"+ courseM.getOneClassMembers(Integer.parseInt(classId)).size()+"人");
            history.add(info);
        }
        return history;
    }

    @Override
    public String insertSign(String username, String classId, String longitude, String latitude,String type,String poseNumber) {
        Date now = new Date();
        //1 一键签到 2 手势签到
        if(type.equals("1"))
        {
            signin sig = new signin(null,Integer.parseInt(username),1,null,longitude+","+latitude,Integer.parseInt(classId),now);
            siginM.insert(sig);
            signin signow = siginM.find(Integer.parseInt(classId),now);
            return signow.getId().toString();
        }else if(type.equals("2")){
            signin sig = new signin(null,Integer.parseInt(username),2,null,longitude+","+latitude+","+poseNumber,Integer.parseInt(classId),now);
            siginM.insert(sig);
            signin signow = siginM.find(Integer.parseInt(classId),now);
            return signow.getId().toString();
        }
       
        return "false";
    }

    @Override
    public String updateSign(String signId, String type) {
        Date endTime = new Date();
         //1 一键签到 2 手势签到
        if(type.equals("1"))
        {
            signin sig = new signin(Integer.parseInt(signId),null,null,endTime,null,null,null);
            if(siginM.updateByPrimaryKeySelective(sig) == 1){
                return "ok";
            }
            
        }else if(type.equals("2")){
            signin sig = new signin(Integer.parseInt(signId),null,null,endTime,null,null,null);
            if(siginM.updateByPrimaryKeySelective(sig) == 1){
                return "ok";
            }
        }
       
        return "false";
    }
    
}
