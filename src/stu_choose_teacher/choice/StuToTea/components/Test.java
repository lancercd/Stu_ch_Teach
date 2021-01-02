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

    final int WIDTH = 850;
    final int HEIGHT = 600;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;


    public Test() {
        super(BoxLayout.Y_AXIS);
        JPanel btnPanel = new JPanel();
        Color color = new Color(203, 220, 217);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH, 80));

        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addBtn = new JButton("添加");
        JButton upBtn = new JButton("修改");
        JButton delBtn = new JButton("删除");


        btnPanel.add(addBtn);
        btnPanel.add(upBtn);
        btnPanel.add(delBtn);

        this.add(btnPanel);
        String[] ts = {"111", "222", "333", "444" , "555"};
        titles = new Vector<>();
        for(String title : ts){
            titles.add(title);

        }

        tableData = new Vector<>();
        tableModel = new DefaultTableModel(tableData, titles);
        table = new JTable(tableModel){

            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        requestData();
        this.add(table);
    }


    public void requestData(){
        StudentServiceImpl stu = new StudentServiceImpl();
        Semester semester = new Semester();
        semester.setSemester_id(1);
//        List<GuideAndStudent> guideAndStudents = stu.getGuideAndStudents(semester);
        tableData.clear();
//        for(GuideAndStudent ele : guideAndStudents){
//            System.out.println(ele);
//        }

    }

}
