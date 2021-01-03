package stu_choose_teacher.choice.StuToTea.dialog;

import stu_choose_teacher.config.Config;
import stu_choose_teacher.domain.GuideAdviser;

import javax.swing.*;
import java.awt.*;

public class SelectTeaDialog extends JDialog {
//    表id
    int teachNum;
//    信息
    GuideAdviser data;

    public SelectTeaDialog(JFrame jf, boolean isModel, String title, int teach_num){
        super(jf, title, isModel);
        this.teachNum = teach_num;
        this.setLocation(getLocationX(), getLocationY());
        //宽度 400px  高度300px
        this.setSize(400, 300);

        FormatDate();
        initConponents();

    }


    //渲染组件
    private void initConponents(){
        //组件
        Box vbox = Box.createVerticalBox();
        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("教师姓名:");
        JLabel nameText = new JLabel(data.getTeacher_name());
        nameBox.add(nameLabel);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameText);


        Box numBox = Box.createHorizontalBox();
        JLabel numLabel = new JLabel("教师工号:");
        JLabel numText = new JLabel(String.valueOf(data.getTeacher_number()));
        numBox.add(numLabel);
        numBox.add(Box.createHorizontalStrut(20));
        numBox.add(numText);

        Box demandBox = Box.createHorizontalBox();
        JLabel demandLabel = new JLabel("要求:");
        JLabel demandText = new JLabel(data.getGuide_adviser_demand());
        demandBox.add(demandLabel);
        demandBox.add(Box.createHorizontalStrut(20));
        demandBox.add(demandText);



        //添加到vbox中
        //添加一个间隔
        vbox.add(Box.createHorizontalStrut(20));
        vbox.add(nameBox);
        //添加一个间隔
        vbox.add(Box.createHorizontalStrut(15));
        vbox.add(numBox);
        vbox.add(Box.createHorizontalStrut(15));
        vbox.add(demandBox);



        //添加到该窗体中
        this.add(vbox);
    }


    private void FormatDate(){
        GuideAdviser data = new GuideAdviser();
        data.setTeacher_name("lc");
        data.setTeacher_number(456789);
        data.setGuide_adviser_demand("要求各种个样子那个的撒发达发");

        this.data = data;

    }

    private int getLocationX(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().width)/2);
    }
    private int getLocationY(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().height)/2);
    }

}
