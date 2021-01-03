package stu_choose_teacher.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Config {
    //窗体title
    public static final String FRAME_TITLE = "学生选择老师";

    //窗体默认宽度 px
    public static final int FRAME_INIT_WEIGHT = 1500;

    //窗体默认高度 px
    public static final int FRAME_INIT_HEIGHT = 900;







//[ 菜单栏 ]

    //左边菜单栏默认宽度 px
    public static final int LEFT_BAR_WEIGHT = 300;

    //左边菜单栏与右边的分割线的宽度 px
    public static final int DIVIDER_SIZE = 2;

    //左边菜单栏 显示用户信息板块 [宽度, 高度] px
//    public static final int USER_INFO_BAR_WIDTH = 200;
//    public static final int USER_INFO_BAR_HEIGHT = 50;

    //组件所在的包
    public static final String componentsPath = "stu_choose_teacher.choice.StuToTea.components.";
    //菜单按钮
    public static final Map<String, String> MENU_BTNS = new HashMap<String, String>();
    static{
        MENU_BTNS.put("查看指导老师", componentsPath + "CheckAllAdviser");
        MENU_BTNS.put("我的选择信息", componentsPath + "CheckStuChooseMessage");
        MENU_BTNS.put("选择指导老师", componentsPath + "SelectAdviser");
    };

    public static final int MENU_BTN_HEIGHT = 100;





}
