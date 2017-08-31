package com.example.cong.myapplication.model;

import java.util.List;

/**
 * Created by Cong on 30/08/2017.
 */

public interface IData{
    void setGroups(List<Group> groups);
    void setTypes(Group group, List<Type> types);
}
