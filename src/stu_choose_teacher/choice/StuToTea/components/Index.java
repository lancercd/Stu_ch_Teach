package stu_choose_teacher.choice.StuToTea.components;

import stu_choose_teacher.domain.Student;

import javax.swing.*;
import java.awt.*;

public class Index extends Box {
    JFrame jf = null;

    Student user = null;
    public void setCurrentUser(Student user){
        this.user = user;
    }

    public Index(Student user) {
        super(BoxLayout.Y_AXIS);
        this.user = user;
        JLabel jLabel = new JLabel("你好，"+user.getStu_name()+"用户。");
        JLabel jLabel3 = new JLabel(" ");
        JLabel jLabel1 = new JLabel("学生指导导师功能模块：");
        JLabel jLabel2 = new JLabel("1.查看指导老师  2.选择指导老师  3.修改信息  4.删除信息");

        jLabel.setFont(new Font("黑体", Font.PLAIN, 24));
        jLabel1.setFont(new Font("黑体", Font.PLAIN, 18));
        jLabel2.setFont(new Font("黑体", Font.PLAIN, 18));

        this.add(jLabel);
        this.add(jLabel3);
        this.add(jLabel1);
        this.add(jLabel2);
//        this.add(new JLabel("首页"));
    }
    public Index( ) {
        super(BoxLayout.Y_AXIS);

    }

    public void init(JFrame jf){
        this.jf = jf;
        
        JLabel jLabel = new JLabel("你好，"+user.getStu_name()+"用户。");
        JLabel jLabel3 = new JLabel(" ");
        JLabel jLabel1 = new JLabel("学生指导导师功能模块：");
        JLabel jLabel2 = new JLabel("1.查看指导老师  2.选择指导老师  3.修改信息  4.删除信息");

        jLabel.setFont(new Font("黑体", Font.PLAIN, 24));
        jLabel1.setFont(new Font("黑体", Font.PLAIN, 18));
        jLabel2.setFont(new Font("黑体", Font.PLAIN, 18));

        this.add(jLabel);
        this.add(jLabel3);
        this.add(jLabel1);
        this.add(jLabel2);

    }
}
