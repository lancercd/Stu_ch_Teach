package stu_choose_teacher.choice.StuToTea.components;

import stu_choose_teacher.Impl.StudentServiceImpl;
import stu_choose_teacher.choice.StuToTea.dialog.SelectTeaDialog;
import stu_choose_teacher.dao.SemesterDao;
import stu_choose_teacher.domain.GuideAndStudent;
import stu_choose_teacher.domain.Semester;
import stu_choose_teacher.domain.Student;
import stu_choose_teacher.utils.BtnFaceUtil;
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

    public void initTable(Semester semester, String searchValue){
        //table title
        Vector<String> vh = getTableTitle();

        //table body
        tableData = requestData(semester, searchValue);

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


    public void initTable(Semester semester){
        initTable(semester,null);
    }

    public void onTableRowClick(int teach_num){

        new SelectTeaDialog(jf, false, "选择老师", teach_num, user.getStu_id()).setVisible(true);
    }

    private Vector<String> getTableTitle(){
        Vector<String> vh = new Vector<String>();
        for(String h : title){
            vh.add(h);
        }
        return vh;
    }


    /**
     * 判断表格单元有没有被选中
     * @return boolean
     */
    private boolean tableIsSelected(){
        if(table.getSelectedColumn() == -1){
            JOptionPane.showMessageDialog(jf, "请选中表格的数据!");
            return false;
        }
        return true;
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
        title.setFont(new Font("黑体", Font.BOLD, 30));

        //中间选择学期部分
        JLabel label = new JLabel("选择学期");
        label.setFont(new Font("楷体", Font.BOLD, 25));
        select = getSelection();

        //右边  btns
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addBtn = new JButton("选择导师");
        BtnFaceUtil.btnFace(addBtn, new Color(39, 174, 96), new Color(255,255,255));

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tableIsSelected()) return;
                int rowIndex = table.getSelectedRow();
                Vector<Object> row = tableData.get(rowIndex);
                int num = (int)row.get(0);
                onTableRowClick(num);
            }
        });

        btnPanel.add(addBtn);


        //添加到容器中
        leftPanel.add(title);
        rightPanel.add(label);
        rightPanel.add(select);
        headerPanel.add(leftPanel);
        headerPanel.add(rightPanel);
        headerPanel.add(btnPanel);
        this.add(headerPanel);

        // 添加搜索框及按钮
        JPanel searchPanel = new JPanel();

        searchPanel.setMaximumSize(new Dimension(800, 200));
        searchPanel.setLayout(new GridLayout(1, 3));

//        JLabel jLabel_input = new JLabel("请输入：  ");
//        JTextArea jTextArea = new JTextArea();
        JTextField jTextField = new JTextField();
        JButton search_button = new JButton("搜索");

        BtnFaceUtil.btnFace(search_button, new Color(200,200,200), new Color(0,0,0));
        search_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchGuide((Semester) select.getSelectedItem(), jTextField.getText());
            }
        });


//        searchPanel.add(jLabel_input);
        searchPanel.add(jTextField);
        searchPanel.add(search_button);
        this.add(searchPanel);

        initTable((Semester) select.getSelectedItem());
        this.add( new JScrollPane(table) ); //要用JScrollPane包才会显示出表头
    }

    public void searchGuide(Semester semester, String searchValue){
        String str = semester.getSemester_name() + searchValue;
        initTable(semester,searchValue);
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


    public Vector<Vector<Object>> requestData(Semester semester, String searchValue){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        StudentServiceImpl stu = new StudentServiceImpl();

        List<GuideAndStudent> guideAndStudents = stu.getGuideAndStudentsBySemester(semester,searchValue);

        for(GuideAndStudent ele : guideAndStudents){
            Vector<Object> row = ele.dataFormat();
            data.add(row);
        }
        return data;
    }

}
