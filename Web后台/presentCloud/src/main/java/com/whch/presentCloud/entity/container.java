package com.whch.presentCloud.entity;

import java.util.List;

public class container {

    private String name;

    private String state;

    private int layer;

    private List<container> sub;

    public container(String name, String state, List<container> sub, int layer) {

        this.name = name;
        this.state = state;
        this.sub = sub;
        this.layer = layer;
    }

    public container() {
    }


    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public container(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<container> getSub() {
        return sub;
    }

    public void setSub(List<container> sub) {
        this.sub = sub;
    }
}
