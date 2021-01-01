package com.choose.stu_tea;

import com.choose.stu_tea.utils.DB;

import java.util.ArrayList;
import java.util.HashMap;

public class StuChooseTeach {
    public static void main(String[] args) {
        ArrayList<HashMap<String, Object>> list = DB.query("select * from answer");
        System.out.println(list);


        //System.out.println(DB.find("select * from answer"));
    }
}
