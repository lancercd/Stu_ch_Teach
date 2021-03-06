package stu_choose_teacher.choice.StuToTea.dialog;

import stu_choose_teacher.Impl.StudentServiceImpl;
import stu_choose_teacher.dao.StudentDao;
import stu_choose_teacher.dao.TutorStuDao;
import stu_choose_teacher.domain.GuideAdviser;
import stu_choose_teacher.domain.TutorStu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifySelectTeaDialog extends JDialog {
    //   教师学生表id
    int id;
    //    用户id
    int stu_id;
    //  是否邮箱/短信通知状态（email：2，message：1，both none：0）
    int email_message_state;
    // 通知内容
    String message;
    // 自我介绍
    String intro;

    //    信息
    GuideAdviser data;

    JRadioButton email_radio;
    JRadioButton message_radio;

    JFrame jf;

    public ModifySelectTeaDialog(JFrame jf, boolean isModel, String title, int id, int stu_id,
                                 int state, String message, String intro){
        super(jf, title, isModel);
        this.id = id;
        this.stu_id = stu_id;
        this.email_message_state = state;
        this.message = message;
        this.intro = intro;

        this.jf = jf;
        this.setLocation(getLocationX() - 200, getLocationY() - 150);

        //宽度 400px  高度300px
        this.setSize(400, 300);

//        FormatDate();

        validateHasSelected();
    }

    /**
     * 判断用户是否已经选择了该老师
     */
    public void validateHasSelected(){
        StudentDao stu = new StudentDao();
        initNormalConponents();

//        if(stu.checkStudentByGuide(id, stu_id)){
//            initNoticeComponents();
//        }else{
//
//            initNormalConponents();
//        }
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



        //单选框
        Box radioBox = Box.createHorizontalBox();
        ButtonGroup group = new ButtonGroup();

        if(email_message_state == 0){
            email_radio = new JRadioButton("邮件通知");
            message_radio = new JRadioButton("短信通知");
        } else if(email_message_state == 2){
            email_radio = new JRadioButton("邮件通知");
            message_radio = new JRadioButton("短信通知", true);
        } else if(email_message_state == 1){
            email_radio = new JRadioButton("邮件通知", true);
            message_radio = new JRadioButton("短信通知");
        }

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

        introText.setText(intro);
        noticeText.setText(message);

        //按钮
        Box btnBox = Box.createHorizontalBox();
        JButton btn = new JButton("确认");
        btnBox.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                submit(intro, notice, email_radio.isSelected());
                JOptionPane.showMessageDialog(jf, "修改成功!");
            }
        });


        //添加到vbox中
        //添加一个间隔
        vbox.add(Box.createHorizontalStrut(20));
        vbox.add(nameBox);

        vbox.add(Box.createHorizontalStrut(15));

        vbox.add(radioBox);




        vbox.add(introBox);
        vbox.add(Box.createHorizontalStrut(15));
        vbox.add(noticeBox);
        vbox.add(Box.createHorizontalStrut(15));
        vbox.add(btnBox);

        //添加到该窗体中
        this.add(vbox);
    }


    //提交选择信息
    private void submit(String intro, String notice, boolean isEmail){
        TutorStuDao tutorStu = new TutorStuDao();
        tutorStu.updateTutorStuByMessage(id, intro, notice, isEmail);
    }


//    private void FormatDate(){
//        GuideAdviser data = new GuideAdviser();
//        data.setTeacher_name("lc");
//        data.setTeacher_number(456789);
//        data.setGuide_adviser_demand("要求");
//
//        this.data = data;
//
//    }

    private int getLocationX(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().width)/2);
    }
    private int getLocationY(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().height)/2);
    }

}
