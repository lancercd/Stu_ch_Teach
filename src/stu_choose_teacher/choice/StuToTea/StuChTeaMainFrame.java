package stu_choose_teacher.choice.StuToTea;



import stu_choose_teacher.choice.StuToTea.components.CheckTeaChStu;
import stu_choose_teacher.choice.StuToTea.components.Test;
import stu_choose_teacher.config.Config;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class StuChTeaMainFrame extends JFrame {
    JSplitPane sp = null;

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


    private Component createMenuBtns(){
        return null;
    }


    /**
     * 左边菜单栏内容
     * @return Component
     */
    private Component createLeftBar(){
        String[] btnsText = Config.MENU_BTNS;
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("管理");
        for(String text : btnsText){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(text);
            root.add(node);
        }
        JTree tree = new JTree(root);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

                createNewFrame(lastPathComponent.toString());
            }
        });
        return tree;
    }

    private void conponentsInit(){

        //分为左右两边
        sp = new JSplitPane();
        sp.setContinuousLayout(true);
        sp.setDividerLocation(Config.LEFT_BAR_WEIGHT);
        sp.setDividerSize(Config.DIVIDER_SIZE);

        JPanel rightBar = new JPanel();


        sp.setLeftComponent(createLeftBar());
        sp.setRightComponent(new Test());
        this.add(sp);
    }


    /**
     * 创建窗口组件到右边
     * @param flag
     */
    private void createNewFrame(String flag){
        //sp.setRightComponent();
//        点击窗口
        //System.out.println(flag);

        sp.setRightComponent(new CheckTeaChStu());

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



//    private class MenuBtnRenderer extends DefaultTreeCellRenderer {
//        private Image rootIcon = null;
//
//        public MenuBtnRenderer(){
//            rootIcon = ImageIO.read();
//        }
//
//        @Override
//        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
//            return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
//        }
//    }
}

