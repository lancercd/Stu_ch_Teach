package stu_choose_teacher.choice.StuToTea.components;

import stu_choose_teacher.domain.Student;

import javax.swing.*;

public class Index extends Box {
    JFrame jf = null;

    Student user = null;
    public void setCurrentUser(Student user){
        this.user = user;
    }

    public Index(Student user) {
        super(BoxLayout.Y_AXIS);
        this.user = user;
        this.add(new JLabel("首页"));
    }
    public Index( ) {
        super(BoxLayout.Y_AXIS);

    }

    public void init(JFrame jf){
        this.jf = jf;
        this.add(new JLabel("首页"));
    }
}
