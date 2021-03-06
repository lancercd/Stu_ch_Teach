package stu_choose_teacher.choice.StuToTea.components;

import stu_choose_teacher.Impl.StudentServiceImpl;
import stu_choose_teacher.choice.StuToTea.dialog.ModifySelectTeaDialog;
import stu_choose_teacher.choice.StuToTea.dialog.SelectTeaDialog;
import stu_choose_teacher.domain.ChooseMessage;
import stu_choose_teacher.domain.Student;
import stu_choose_teacher.domain.TutorStu;
import stu_choose_teacher.utils.BtnFaceUtil;
import stu_choose_teacher.utils.TableUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.List;
import java.util.Vector;

public class CheckStuChooseMessage extends Box {
    JFrame jf = null;

    String[] title = {"id", "教师编号", "教师姓名", "指导教师确认", "指导教师要求", "通知类型", "通知内容", "自我介绍", "邮件审核", "短信审核"};
    String boxTitle = "查看我选择的老师";


    final int WIDTH = 850;
    final int HEIGHT = 50;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector<Object>> tableData;
    private TableModel tableModel;

    Student user = null;
    public void setCurrentUser(Student user){
        this.user = user;
    }

    public CheckStuChooseMessage( ) {
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


    private void initTable(){
        //table title
        Vector<String> vh = getTableTitle();

        //table body
        tableData = requestData();

        tableModel = new DefaultTableModel(tableData, vh);
        table.setModel(tableModel);
        TableUtil.tableFace(table);

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int rowIndex = table.getSelectedRow();
                    Vector<Object> row = tableData.get(rowIndex);

                    int num = (int) row.get(0);
//                    onTableRowClick(num);
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

//    public void onTableRowClick(int teach_num){
//        System.out.println(teach_num);
//        new SelectTeaDialog(jf, false, "选择老师", teach_num, user.getStu_id()).setVisible(true);
//    }

    private Vector<String> getTableTitle(){
        Vector<String> vh = new Vector<String>();
        for(String h : title){
            vh.add(h);
        }
        return vh;
    }


    private void initComponent(){

        JPanel headerPanel = new JPanel();
        headerPanel.setMaximumSize(new Dimension(850, 200));
        headerPanel.setLayout(new GridLayout(1, 3));
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        //左边title 窗口标题
        JLabel title = new JLabel(boxTitle);
        title.setFont(new Font("黑体", Font.BOLD, 30));
        leftPanel.add(title);


        //中间选择学期部分
        JLabel label = new JLabel();

        //右边  btns
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); 

        JButton delBtn = new JButton("删除");
        BtnFaceUtil.btnFace(delBtn, new Color(251, 96, 80), new Color(255, 255, 255));
        JButton modifyBtn = new JButton("修改");
        BtnFaceUtil.btnFace(modifyBtn, new Color(243, 156, 18), new Color(255, 255, 255));
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delBtnClick();
            }
        });
        modifyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyBtnClick();
            }
        });

        btnPanel.add(delBtn);
        btnPanel.add(modifyBtn);

        //添加到容器中
        rightPanel.add(label);
        rightPanel.add(label);
        headerPanel.add(leftPanel);
        headerPanel.add(rightPanel);
        headerPanel.add(btnPanel);
        this.add(headerPanel);


        initTable();
        this.add( new JScrollPane(table) ); //要用JScrollPane包才会显示出表头
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


    /**
     * 点击删除按钮 调用此函数
     */
    public void delBtnClick(){
        if(!tableIsSelected()) return;


        String check_status = (String)tableData.get(table.getSelectedRow()).get(3);

        if(!check_status.equals("待审核")){
            JOptionPane.showMessageDialog(jf, "已确认无法修改!");
            return;
        }


        int id = (int)tableData.get(table.getSelectedRow()).get(0);
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.deleteTutorStu(id);
        initTable();
        JOptionPane.showMessageDialog(jf, "删除成功!");
    }


    /**
     * 点击修改按钮  调用此函数
     */
    public void modifyBtnClick(){
        if(!tableIsSelected()) return;
        int id = (int)tableData.get(table.getSelectedRow()).get(0);
        String adviser_check = (String)tableData.get(table.getSelectedRow()).get(3);
        String message_check = (String)tableData.get(table.getSelectedRow()).get(8);
        String email_check = (String)tableData.get(table.getSelectedRow()).get(9);

        String email_message = (String) tableData.get(table.getSelectedRow()).get(5);
        String message = (String)tableData.get(table.getSelectedRow()).get(6);
        String intro = (String)tableData.get(table.getSelectedRow()).get(7);

        if(adviser_check.equals("已确认")){
            JOptionPane.showMessageDialog(jf, "导师已确认无法修改!");
            return;
        }
        if(!message_check.equals("未审核") || !email_check.equals("未审核")){
            JOptionPane.showMessageDialog(jf, "已被审核无法修改!");
            return;
        }

        int email_message_state = 0;
        if(email_message.equals("短信通知")){
            email_message_state = 2;
        }else if(email_message.equals("邮件通知")){
            email_message_state = 1;
        }

        System.out.println(email_message_state);

        new ModifySelectTeaDialog(jf, true, "修改信息", id, user.getStu_id(), email_message_state,
                message, intro).setVisible(true);

        initTable();
//        JOptionPane.showMessageDialog(jf, "删除成功!");
    }



    private Vector<Vector<Object>> requestData(){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        StudentServiceImpl stu = new StudentServiceImpl();

        List<ChooseMessage> chooseMessages = stu.getChooseMessage(user.getStu_id());
        for(ChooseMessage ele : chooseMessages){
            Vector<Object> row = ele.dataFormat();
            data.add(row);
        }
        return data;
    }



}

