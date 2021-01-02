package stu_choose_teacher.choice.StuToTea.components;

import stu_choose_teacher.Impl.StudentServiceImpl;
import stu_choose_teacher.domain.GuideAndStudent;
import stu_choose_teacher.domain.Semester;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class Test extends Box {

    String[] title = {"111", "222"};

    final int WIDTH = 850;
    final int HEIGHT = 50;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector<Object>> tableData;
    private TableModel tableModel;


    public Test() {
        super(BoxLayout.Y_AXIS);
        initComponent();
        initTable();

    }


    public void initTable(){
        tableData = new Vector<Vector<Object>>();


        titles = new Vector<String>();
        titles.add("ok");
        titles.add("123");
        Vector<String> vh = new Vector<String>();
        vh.add("姓名");
        vh.add("年龄");
        tableData = requestData();

        tableModel = new DefaultTableModel(tableData, vh);
        table = new JTable(tableModel){

            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(table);
    }


    public void initComponent(){
        JPanel btnPanel = new JPanel();
//        Color color = new Color(203, 220, 217);
//        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addBtn = new JButton("添加");
        JButton upBtn = new JButton("修改");
        JButton delBtn = new JButton("删除");


        btnPanel.add(addBtn);
        btnPanel.add(upBtn);
        btnPanel.add(delBtn);

        this.add(btnPanel);
    }


    public Vector<Vector<Object>> requestData(){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        StudentServiceImpl stu = new StudentServiceImpl();
        Semester semester = new Semester();
        semester.setSemester_id(1);
        List<GuideAndStudent> guideAndStudents = stu.getGuideAndStudents(semester);

        for(GuideAndStudent ele : guideAndStudents){
            Vector<Object> row = ele.dataFormat();
            data.add(row);
        }
        return data;

    }

}
