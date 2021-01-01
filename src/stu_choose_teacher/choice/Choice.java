package stu_choose_teacher.choice;

import stu_choose_teacher.dao.UserDao;
import stu_choose_teacher.domain.User;

public class Choice {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User username = userDao.getUsername(1);

        System.out.println(username);
    }
}
