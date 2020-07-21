package com.whch.presentCloud.utils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.maxmind.geoip2.DatabaseReader;
import org.apache.commons.lang.StringUtils;

/**
 * 
 * @description: 获取客户端IP地址
 * @author: paulandcode
 * @email: paulandcode@gmail.com
 * @since: 2018年9月17日 下午3:44:51
 */
public class IPUtils {
    private static Logger logger = LoggerFactory.getLogger(IPUtils.class);

    /**
     * 获取客户端IP地址
     * 
     * 使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
     * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-Forwarded-For中第一个非unknown的有效IP字符串，则为真实IP地址
     */
    public static String getIP(HttpServletRequest request) {
        String ip = null;
        try {
            ip = request.getHeader("x-forwarded-for");
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } catch (Exception e) {
            logger.error("IPUtils ERROR ", e);
        }
        return ip;
    }

    /**
     * 
     * @description: 获得国家 
     * @param reader
     * @param ip
     * @return
     * @throws Exception
     */
    public static String getCountry(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getCountry().getNames().get("zh-CN");
    }

    /**
     * 
     * @description: 获得省份 
     * @param reader
     * @param ip
     * @return
     * @throws Exception
     */
    public static String getProvince(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getMostSpecificSubdivision().getNames().get("zh-CN");
    }

    /**
     * 
     * @description: 获得城市 
     * @param reader
     * @param ip
     * @return
     * @throws Exception
     */
    public static String getCity(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getCity().getNames().get("zh-CN");
    }
    
    /**
     * 
     * @description: 获得经度 
     * @param reader
     * @param ip
     * @return
     * @throws Exception
     */
    public static Double getLongitude(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getLocation().getLongitude();
    }
    
      /**
     * 
     * @description: 获得jing纬度
     * @param reader
     * @param ip
     * @return
     * @throws Exception
     */
    public static Double[] getJingWeiDu(String ip) throws Exception {
        String path = "C:/D/工程实训/GeoLite2-City.mmdb";
    	// 创建 GeoLite2 数据库
    	File database = new File(path);
    	// 读取数据库内容
    	DatabaseReader reader = new DatabaseReader.Builder(database).build();
        Double latitue[] = new Double[2];
        latitue[0] = reader.city(InetAddress.getByName(ip)).getLocation().getLongitude();
        latitue[1] = reader.city(InetAddress.getByName(ip)).getLocation().getLatitude();
        return latitue;
    }

    /**
     * 
     * @description: 获得纬度
     * @param reader
     * @param ip
     * @return
     * @throws Exception
     */
    public static Double getLatitude(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getLocation().getLatitude();
    }
  
    

    public static void main(String[] args) throws Exception {
    	// // String path = req.getSession().getServletContext().getRealPath("/WEB-INF/classes/GeoLite2-City.mmdb");
    	// String path = "C:/D/工程实训/GeoLite2-City.mmdb";
    	// // 创建 GeoLite2 数据库
    	// File database = new File(path);
    	// // 读取数据库内容
    	// DatabaseReader reader = new DatabaseReader.Builder(database).build();
    	// // 访问IP
    	// String ip = "223.91.65.1";
        // String site = IPUtils.getCountry(reader, ip) + "-" + IPUtils.getProvince(reader, ip) + "-" + IPUtils.getCity(reader, ip)+ "-" + IPUtils.getLongitude(reader, ip)+ "-" + IPUtils.getLatitude(reader, ip);
        String time = "06月30日,04时";
        Date now = new Date();
        String da = 1900+now.getYear()+"年"+time.substring(0,6)+" "+time.substring(7,9)+":00:00";
        System.out.println(da);;
        SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        Date sr = formater.parse(da);
    	System.out.println(sr);
	}


}