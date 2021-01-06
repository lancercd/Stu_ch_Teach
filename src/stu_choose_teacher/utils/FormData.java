package stu_choose_teacher.utils;

public class FormData {
    public static String notice_message_to_string(int flag){
        //not validate
        String status[] = {"未审核", "审核通过", "不同意"};
        return status[flag];
    }

//    public static String notice_string_to_int(String flag){
        //not validate
//        String status[] = {"未审核", "审核通过", "不同意"};
//        return status[flag];
//    }


    public static String check_notice_type(int message, int email){
        if(message == 0 && email == 0){
            return "不需要通知";
        }else if(message != 2 && email != 2){
            if(message == 1 && email == 0){
                return "短信通知";
            }

            if(email == 1 && message == 0){
                return "邮件通知";
            }
        } else {
            if(message == 2){
                return "短信已通知";
            }

            if(email == 2){
                return "邮件已通知";
            }
        }

        return "未知状态";
    }



    public static String check_tea_validate_status(int flag){
        if(flag < 0 || flag > 2) return "unknow";
        String[] status = {"待审核", "已确认", "不同意"};
        return status[flag];
    }
}
