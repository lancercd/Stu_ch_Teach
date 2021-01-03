package stu_choose_teacher.choice.StuToTea.components;

import stu_choose_teacher.Impl.StudentServiceImpl;
import stu_choose_teacher.domain.GuideAndStudent;
import stu_choose_teacher.domain.Semester;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

public class Test extends Box {

    String[] title = {"教师学号", "教师姓名", "已选择学生姓名"};
    JComboBox select;

    final int WIDTH = 850;
    final int HEIGHT = 50;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector<Object>> tableData;
    private TableModel tableModel;


    public Test() {
        super(BoxLayout.Y_AXIS);
        table = new JTable(tableModel){

            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        initComponent();
    }


    public void initTable(Semester semester){
        //table title
        Vector<String> vh = getTableTitle();

        //table body
        tableData = requestData(semester);
        System.out.println(tableData);

        tableModel = new DefaultTableModel(tableData, vh);
        table.setModel(tableModel);
    }

    private Vector<String> getTableTitle(){
        Vector<String> vh = new Vector<String>();
        for(String h : title){
            vh.add(h);
        }
        return vh;
    }


    public void initComponent(){
        //JPanel btnPanel = new JPanel();
//        Color color = new Color(203, 220, 217);
//        btnPanel.setBackground(color);
//        btnPanel.setMaximumSize(new Dimension(WIDTH, HEIGHT));
//
//        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
//
//        JButton addBtn = new JButton("添加");
//        JButton upBtn = new JButton("修改");
//        JButton delBtn = new JButton("删除");
//
//
//        btnPanel.add(addBtn);
//        btnPanel.add(upBtn);
//        btnPanel.add(delBtn);
//        this.add(btnPanel);
        JPanel headerPanel = new JPanel();
        headerPanel.setMaximumSize(new Dimension(850, 200));
        headerPanel.setLayout(new GridLayout(1, 2));
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        leftPanel.setBackground(Color.RED);
        rightPanel.setBackground(Color.GREEN);

        //左边title 窗口标题
        JLabel title = new JLabel("查看所有老师");
        title.setFont(new Font("黑体", Font.BOLD, 20));
        leftPanel.add(title);


        //右边选择学期部分
        JLabel label = new JLabel("选择学期");
        select = getSelection();


        //添加到容器中
        rightPanel.add(label);
        rightPanel.add(select);
        headerPanel.add(leftPanel);
        headerPanel.add(rightPanel);
        this.add(headerPanel);


        initTable((Semester) select.getSelectedItem());
        this.add( new JScrollPane(table) ); //要用JScrollPane包才会显示出表头
    }


    /**
     * 下拉列表框  显示所有学期
     * @return
     */
    private JComboBox getSelection(){
        select = new JComboBox();
        Semester semester1 = new Semester();
        semester1.setSemester_id(1);
        semester1.setSemester_name("第一学期");
        Semester semester2 = new Semester();
        semester2.setSemester_id(2);
        semester2.setSemester_name("第二学期");
        Semester semester3 = new Semester();
        semester3.setSemester_id(3);
        semester3.setSemester_name("第三学期");
        select.addItem(semester1);
        select.addItem(semester2);
        select.addItem(semester3);

        select.setSelectedIndex(0);
        Semester semester = new Semester();
        semester.setSemester_id(1);

        select.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    initTable((Semester) select.getSelectedItem());
                }
            }
        });

        return select;
    }


    public Vector<Vector<Object>> requestData(Semester semester){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        StudentServiceImpl stu = new StudentServiceImpl();

        List<GuideAndStudent> guideAndStudents = stu.getGuideAndStudents(semester);

        for(GuideAndStudent ele : guideAndStudents){
            Vector<Object> row = ele.dataFormat();
            data.add(row);
        }
        return data;

    }

}
