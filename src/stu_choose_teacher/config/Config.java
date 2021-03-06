package stu_choose_teacher.config;

import java.util.*;

public class Config {
    //窗体title
    public static final String FRAME_TITLE = "学生选择老师";

    //窗体默认宽度 px
    public static final int FRAME_INIT_WEIGHT = 1300;   // 1500

    //窗体默认高度 px
    public static final int FRAME_INIT_HEIGHT = 700;    // 900




//[ 菜单栏 ]

    //左边菜单栏默认宽度 px
    public static final int LEFT_BAR_WEIGHT = 300;

    //左边菜单栏与右边的分割线的宽度 px
    public static final int DIVIDER_SIZE = 2;


    //组件所在的包
    public static final String componentsPath = "stu_choose_teacher.choice.StuToTea.components.";
    //菜单按钮
    public static final Map<String, String> MENU_BTNS = new LinkedHashMap<String, String>();
    static{
        MENU_BTNS.put("首页", componentsPath + "Index");
        MENU_BTNS.put("查看/选择指导老师", componentsPath + "CheckAllAdviser");
        MENU_BTNS.put("我的选择信息", componentsPath + "CheckStuChooseMessage");

    };



}
