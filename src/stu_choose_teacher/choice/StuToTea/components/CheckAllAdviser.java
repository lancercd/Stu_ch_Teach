package stu_choose_teacher.choice.StuToTea.components;

import stu_choose_teacher.Impl.StudentServiceImpl;
import stu_choose_teacher.choice.StuToTea.dialog.SelectTeaDialog;
import stu_choose_teacher.dao.SemesterDao;
import stu_choose_teacher.domain.GuideAndStudent;
import stu_choose_teacher.domain.Semester;
import stu_choose_teacher.domain.Student;
import stu_choose_teacher.utils.TableUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

public class CheckAllAdviser extends Box {

    String[] title = {"id", "教师学号", "教师姓名", "已选择学生姓名"};
    String boxTitle = "查看所有老师";
    JComboBox select;

    JFrame jf = null;

    final int WIDTH = 850;
    final int HEIGHT = 50;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector<Object>> tableData;
    private TableModel tableModel;

    Student user = null;

    public CheckAllAdviser() {

        super(BoxLayout.Y_AXIS);
    }

    public void init(JFrame jf){
        this.jf = jf;
        table = new JTable(tableModel){

            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        initComponent();
    }

    public void setCurrentUser(Student user){
        this.user = user;
    }


    public void initTable(Semester semester){
        //table title
        Vector<String> vh = getTableTitle();

        //table body
        tableData = requestData(semester);

        tableModel = new DefaultTableModel(tableData, vh);
        table.setModel(tableModel);
        TableUtil.tableFace(table);


        //表格点击事件
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int rowIndex = table.getSelectedRow();
                    Vector<Object> row = tableData.get(rowIndex);
                    int num = (int)row.get(0);
                    onTableRowClick(num);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    public void onTableRowClick(int teach_num){
        System.out.println(teach_num);
        new SelectTeaDialog(jf, false, "选择老师", teach_num, user.getStu_id()).setVisible(true);
    }

    private Vector<String> getTableTitle(){
        Vector<String> vh = new Vector<String>();
        for(String h : title){
            vh.add(h);
        }
        return vh;
    }


    public void initComponent(){

        JPanel headerPanel = new JPanel();
        headerPanel.setMaximumSize(new Dimension(850, 200));
        headerPanel.setLayout(new GridLayout(1, 3));
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        //左边title 窗口标题
        JLabel title = new JLabel(boxTitle);
        title.setFont(new Font("黑体", Font.BOLD, 20));
        leftPanel.add(title);


        //中间选择学期部分
        JLabel label = new JLabel("选择学期");
        select = getSelection();

        //右边  btns
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addBtn = new JButton("选择导师");
//        JButton upBtn = new JButton("修改");
//        JButton delBtn = new JButton("删除");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new SelectTeaDialog(jf, false, "选择老师").setVisible(true);
            }
        });

        btnPanel.add(addBtn);
//        btnPanel.add(upBtn);
//        btnPanel.add(delBtn);


        //添加到容器中
        rightPanel.add(label);
        rightPanel.add(select);
        headerPanel.add(leftPanel);
        headerPanel.add(rightPanel);
        headerPanel.add(btnPanel);
        this.add(headerPanel);


        initTable((Semester) select.getSelectedItem());
        this.add( new JScrollPane(table) ); //要用JScrollPane包才会显示出表头
    }

    public void setSemester(JComboBox ComboBox){
        SemesterDao semesterDao = new SemesterDao();
        List<Semester> semesters = semesterDao.getAllSemesters();
        for(Semester se : semesters){
            ComboBox.addItem(se);
        }
    }

    public boolean validateSelectCount(){
        if(select.getItemCount() == 0) return false;
        return true;
    }


    /**
     * 下拉列表框  显示所有学期
     * @return
     */
    private JComboBox getSelection(){
        select = new JComboBox();


        setSemester(select);
        if(validateSelectCount()){
            select.setSelectedIndex(0);
        }



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

        List<GuideAndStudent> guideAndStudents = stu.getGuideAndStudentsBySemester(semester);

        for(GuideAndStudent ele : guideAndStudents){
            Vector<Object> row = ele.dataFormat();
            data.add(row);
        }
        return data;
    }

}
