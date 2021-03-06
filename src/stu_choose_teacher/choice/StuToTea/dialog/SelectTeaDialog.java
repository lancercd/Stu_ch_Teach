package stu_choose_teacher.choice.StuToTea.dialog;

import stu_choose_teacher.Impl.StudentServiceImpl;
import stu_choose_teacher.config.Config;
import stu_choose_teacher.dao.GuideAdviserDao;
import stu_choose_teacher.dao.StudentDao;
import stu_choose_teacher.domain.GuideAdviser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTeaDialog extends JDialog {
    //   指导老师id
    int id;
    //    用户id
    int stu_id;
    //    信息
    GuideAdviser data;

    JRadioButton email_radio;
    JRadioButton message_radio;

    JFrame jf;

    public SelectTeaDialog(JFrame jf, boolean isModel, String title, int id, int stu_id){
        super(jf, title, isModel);
        this.id = id;
        this.stu_id = stu_id;
        this.jf = jf;
        this.setLocation(getLocationX() - 200, getLocationY() - 150);

        //宽度 400px  高度300px
        this.setSize(400, 300);

        FormatDate(id);

        validateHasSelected();
    }

    /**
     * 判断用户是否已经选择了该老师
     */
    public void validateHasSelected(){
        StudentDao stu = new StudentDao();

        if(stu.checkStudentByGuide(id, stu_id)){
            initNoticeComponents();
        }else{

            initNormalConponents();
        }
    }

    /**
     * 该学生已经选了该老师了
     */
    private void initNoticeComponents(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel noticeLabel = new JLabel("您已经选择了该老师了");
        noticeLabel.setFont(new Font("黑体", Font.BOLD, 20));

        this.add(noticeLabel);

    }


    /**
     * 未选择该老师 渲染组件
     */
    private void initNormalConponents(){
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

        //单选框
        Box radioBox = Box.createHorizontalBox();
        ButtonGroup group = new ButtonGroup();
        email_radio = new JRadioButton("邮件通知", true);
        message_radio = new JRadioButton("短信通知");
        group.add(email_radio);
        group.add(message_radio);

        radioBox.add(email_radio);
        radioBox.add(Box.createHorizontalStrut(20));
        radioBox.add(message_radio);

        //消息内容
        Box introBox = Box.createHorizontalBox();
        JLabel introLabel = new JLabel("介绍:");
        JTextField introText = new JTextField(15);
        introBox.add(introLabel);
        introBox.add(Box.createHorizontalStrut(20));
        introBox.add(introText);

        //消息内容
        Box noticeBox = Box.createHorizontalBox();
        JLabel noticeLabel = new JLabel("通知:");
        JTextField noticeText = new JTextField(15);
        noticeBox.add(noticeLabel);
        noticeBox.add(Box.createHorizontalStrut(20));
        noticeBox.add(noticeText);

        //按钮
        Box btnBox = Box.createHorizontalBox();
        JButton btn = new JButton("确认");
        btnBox.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了");
                String notice = noticeText.getText().trim();
                String intro = introText.getText().trim();
                if(intro.isEmpty()){
                    JOptionPane.showMessageDialog(jf, "请填写介绍信息!");
                    return;
                }
                if(notice.isEmpty()){
                    JOptionPane.showMessageDialog(jf, "请填写通知信息!");
                    return;
                }
                submit(email_radio.isSelected(), intro, notice);
                JOptionPane.showMessageDialog(jf, "添加成功!");
            }
        });


        //添加到vbox中
        //添加一个间隔
        vbox.add(Box.createHorizontalStrut(20));
        vbox.add(nameBox);
        //添加一个间隔
        vbox.add(Box.createHorizontalStrut(15));
        vbox.add(numBox);
        vbox.add(Box.createHorizontalStrut(15));
        vbox.add(demandBox);


        vbox.add(radioBox);
        vbox.add(introBox);
        vbox.add(noticeBox);
        vbox.add(btnBox);

        System.out.println("ok");
        //添加到该窗体中
        this.add(vbox);
    }


    //提交选择信息
    private void submit(boolean isEmail, String intro, String notice){
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.chooseGuide(stu_id, id, intro, isEmail? 1:0, isEmail? 0: 1, notice);
    }


    private void FormatDate(int id){
        GuideAdviser data = new GuideAdviser();

        GuideAdviserDao guideAdviserDao = new GuideAdviserDao();
        GuideAdviser guideAdviser = guideAdviserDao.getGuideAdviser(id);

        data.setTeacher_name(guideAdviser.getTeacher_name());
        data.setTeacher_number(guideAdviser.getTeacher_number());
        data.setGuide_adviser_demand(guideAdviser.getGuide_adviser_demand());

        this.data = data;

    }

    private int getLocationX(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().width)/2);
    }
    private int getLocationY(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().height)/2);
    }

}
