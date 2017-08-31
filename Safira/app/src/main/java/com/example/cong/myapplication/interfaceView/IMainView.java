package com.example.cong.myapplication.interfaceView;

import com.example.cong.myapplication.model.Group;
import com.example.cong.myapplication.model.Type;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Cong on 30/08/2017.
 */

public interface IMainView {
    public void setUpViewOfDraw(List<Group> groups, HashMap<Group,List<Type>> types);
}
