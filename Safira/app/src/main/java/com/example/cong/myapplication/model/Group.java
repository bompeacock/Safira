package com.example.cong.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cong on 30/08/2017.
 */

public class Group {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group group = (Group) o;

        return id == group.id;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}
