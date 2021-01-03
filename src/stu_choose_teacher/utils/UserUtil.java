package stu_choose_teacher.utils;

import stu_choose_teacher.config.Config;

public class UserUtil {
    public static int getUserId(){
        String userClassNamelass = Config.USER_CLASS_NAME;
        User user;
        try {
            Class userClass = Class.forName(userClassNamelass);
            user  = (User) userClass.newInstance();
            return user.getUserId();
        } catch (ClassNotFoundException e) {

            System.out.println("user类配置错误 未找到");
        } catch (IllegalAccessException e) {
            System.out.println("user类配置错误");
        } catch (InstantiationException e) {
            System.out.println("user类配置错误");
        }
        return 0;
    }
}
