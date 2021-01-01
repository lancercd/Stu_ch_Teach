package stu_choose_teacher.choice.StuToTea;

import stu_choose_teacher.config.Config;

import javax.swing.*;
import java.awt.*;

public class StuChTeaMainFrame extends JFrame {

    public StuChTeaMainFrame(){
        this.init();
    }

    /**
     * 初始化窗体
     */
    private void init(){
        FrameInit();
        conponentsInit();

        this.setVisible(true);
    }


    /**
     * 创建基本窗体
     */
    private void FrameInit()
    {
        this.setTitle(Config.FRAME_TITLE);
        this.setVisible(true);
        this.setSize(Config.FRAME_INIT_WEIGHT, Config.FRAME_INIT_HEIGHT);
        this.setLocation(getLocationX(), getLocationY());
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /**
     * 创建菜单栏按钮
     */
//    private JPanel createMenuBtns(int width, int height){
//        String[] btnsText = Config.MENU_BTNS;
//        JPanel container = new JPanel();
//        container.setBackground(Color.GREEN);
////        container.setLayout(new FlowLayout(FlowLayout.CENTER));
//        container.setLayout(new GridLayout(btnsText.length, 1));
//        container.setSize(width, height);
//        //Config.MENU_BTN_HEIGHT * btnsText.length
//
//
//        for(String text : btnsText){
//            JPanel c = new JPanel();
//            c.setSize(300, 50);
//            JButton button = new JButton(text);
//            c.add(button);
//            container.add(c);
//        }
//        return container;
//    }
    private Component createMenuBtns(){
        String[] btnsText = Config.MENU_BTNS;
        JTabbedPane tab = new JTabbedPane(SwingConstants.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);

        for(String btn : btnsText){
//            tab.addTab(btn, );
        }


        return tab;
    }

    private JPanel createUserInfoPanel(int width, int height){
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setSize(width, height);
        userInfoPanel.setBackground(Color.BLACK);
//        userInfoPanel.setLayout(new GridLayout(2,1));
        userInfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        Label username = new Label("lc");
        username.setFont(new Font("黑体", Font.BOLD, 20));
        Label user_number = new Label("1311282756wwo");

        userInfoPanel.add(username);
        userInfoPanel.add(user_number);
        return userInfoPanel;
    }


    /**
     * 左边菜单栏内容
     * @return Component
     */
    private JPanel createLeftBar(){
        JPanel leftBar = new JPanel();


        leftBar.setBackground(Color.blue);
        leftBar.setLayout(null);

//        leftBar.add(createUserInfoPanel(250,80));
//        leftBar.add(createUserInfoPanel(250,80));
        leftBar.add(createMenuBtns());
        return leftBar;
    }

    private void conponentsInit(){

        //分为左右两边
//        JSplitPane sp = new JSplitPane();
//        sp.setContinuousLayout(true);
//        sp.setDividerLocation(Config.LEFT_BAR_WEIGHT);
//        sp.setDividerSize(Config.DIVIDER_SIZE);
//
//
//        JPanel rightBar = new JPanel();


//        sp.setLeftComponent(createLeftBar());
//        sp.setLeftComponent(createLeftBar());
//        sp.setRightComponent(rightBar);
//        this.add(sp);
    }



    private int getLocationX(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-getWidth() / 2;
    }
    private int getLocationY(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-getHeight() / 2;
    }




    public static void main(String[] args) {
        new StuChTeaMainFrame();
    }
}
