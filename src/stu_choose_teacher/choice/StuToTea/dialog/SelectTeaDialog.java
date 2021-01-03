package stu_choose_teacher.choice.StuToTea.dialog;

import stu_choose_teacher.config.Config;

import javax.swing.*;
import java.awt.*;

public class SelectTeaDialog extends JDialog {

    public SelectTeaDialog(JFrame jf, boolean isModel, String title){
        super(jf, title, isModel);
        this.setSize(Config.DIALOG_WIDRH, Config.DIALOG_HEIGHT);
        this.setLocation(getLocationX(), getLocationY());

        //组件
        Box vbox = Box.createVerticalBox();
        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("图书名称");
        JTextField nameField = new JTextField(15);
        nameBox.add(nameLabel);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);


        Box btnBox = Box.createHorizontalBox();
        JButton addBtn = new JButton("添加");
        btnBox.add(addBtn);


        //添加到vbox中
        //添加一个间隔
        vbox.add(Box.createHorizontalStrut(20));
        vbox.add(nameBox);
        //添加一个间隔
        vbox.add(Box.createHorizontalStrut(15));
        vbox.add(btnBox);


        //添加到该窗体中
        this.add(vbox);

    }

    private int getLocationX(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-getWidth() / 2;
    }
    private int getLocationY(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-getHeight() / 2;
    }

}
