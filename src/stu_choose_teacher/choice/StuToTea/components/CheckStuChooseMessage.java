package stu_choose_teacher.choice.StuToTea.components;

import stu_choose_teacher.Impl.StudentServiceImpl;
import stu_choose_teacher.domain.ChooseMessage;
import stu_choose_teacher.domain.Student;
import stu_choose_teacher.utils.TableUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class CheckStuChooseMessage extends Box {
    JFrame jf = null;

    String[] title = {"教师编号", "教师姓名", "指导教师确认", "指导教师要求", "通知内容", "我的自我介绍", "邮件通知", "短信通知"};
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


    public void initTable(){
        //table title
        Vector<String> vh = getTableTitle();

        //table body
        tableData = requestData();
        System.out.println(tableData);

        tableModel = new DefaultTableModel(tableData, vh);
        table.setModel(tableModel);
        TableUtil.tableFace(table);
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


        //左边title 窗口标题
        JLabel title = new JLabel(boxTitle);
        title.setFont(new Font("黑体", Font.BOLD, 20));


        headerPanel.add(title);
        this.add(headerPanel);


        initTable();
        this.add( new JScrollPane(table) ); //要用JScrollPane包才会显示出表头
    }







    public Vector<Vector<Object>> requestData(){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        StudentServiceImpl stu = new StudentServiceImpl();

        List<ChooseMessage> chooseMessages = stu.getChooseMessage(user.getStu_id());
        System.out.println(chooseMessages);
        for(ChooseMessage ele : chooseMessages){
            Vector<Object> row = ele.dataFormat();
            data.add(row);
        }
        return data;

    }

}

