package com.example.cong.myapplication.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cong on 26/08/2017.
 */

public class SearchRequest implements Serializable {
    private int page = 0;
    private int group = 0;
    private int id = 0;

    public int getPage() {
        return page;
    }

    public int getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addPage(){
        page += 1;
    }

    public Map<String,String> castToMap(){
        Map<String,String> map = new HashMap<>();
        if(group!=0) map.put("groupId",group+"");
        map.put("page",page+"");
        map.put("size",10+"");

        return map;
    }
}
