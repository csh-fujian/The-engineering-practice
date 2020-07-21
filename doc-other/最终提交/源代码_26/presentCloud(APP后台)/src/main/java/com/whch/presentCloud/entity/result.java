package com.whch.presentCloud.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class result {

    private List<Map> result;
    private String info;
    private String state;
    private String role;
    private String token;
    private HashMap<String,Object> map;
    public result(){
        this.map = new HashMap<>();
    }
    public List<Map> getResult() {
        return result;
    }

    public void setResult(List<Map> result) {
        this.result = result;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public HashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(String str,Object obj) {
       
        this.map.put(str, obj);
       
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }
   

	
}