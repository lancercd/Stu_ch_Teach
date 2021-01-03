package stu_choose_teacher.utils;

public class FormData {
    public static String notice_message_to_string(int flag){
        //not validate
        String status[] = {"未审核", "审核通过", "不同意"};
        return status[flag];
    }
}
