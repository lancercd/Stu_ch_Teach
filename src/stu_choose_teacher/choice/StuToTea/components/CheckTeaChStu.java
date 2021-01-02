package stu_choose_teacher.choice.StuToTea.components;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class CheckTeaChStu extends Box {

    final int WIDTH = 850;
    final int HEIGHT = 80;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector<Object>> tableData;
    private TableModel tableModel;


    public CheckTeaChStu() {
        super(BoxLayout.Y_AXIS);
        JPanel btnPanel = new JPanel();
        Color color = new Color(203, 220, 217);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addBtn = new JButton("添加");
        JButton upBtn = new JButton("修改");
        JButton delBtn = new JButton("删除");


        btnPanel.add(addBtn);
        btnPanel.add(upBtn);
        btnPanel.add(delBtn);

        this.add(btnPanel);
        test();

    }

    public void test() {


        Vector<String> vh = new Vector<String>();
        vh.add("姓名");
        vh.add("年龄");

        //表数据---多行多列，二维
        Vector< Vector<Object> > vd = new Vector<Vector<Object>>();
        //第一行数据
        Vector<Object> d1 = new Vector<Object>();
        d1.add("Jack");
        d1.add(23);
        //第二行数据
        Vector<Object> d2 = new Vector<Object>();
        d2.add("张三");
        d2.add(22);
        //把d1,d2添加到vd
        vd.add(d1);
        vd.add(d2);

        final DefaultTableModel dtm = new DefaultTableModel(vd,vh);
        final JTable table = new JTable(dtm);
        this.add( new JScrollPane(table) ); //要用JScrollPane包才会显示出表头
        System.out.println(vd);
        setVisible(true);
    }

}

