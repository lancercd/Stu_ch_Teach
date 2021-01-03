package stu_choose_teacher.choice.StuToTea;



import stu_choose_teacher.choice.StuToTea.components.CheckAllAdviser;
import stu_choose_teacher.choice.StuToTea.components.CheckStuChooseMessage;
import stu_choose_teacher.choice.StuToTea.components.Index;
import stu_choose_teacher.config.Config;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

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

    private String[] getMenuBtnText(){
        String[] btnsText = new String[Config.MENU_BTNS.size()];
        int i=0;
        for(String btn : Config.MENU_BTNS.keySet()){
            btnsText[i++] = btn;
        }
        return btnsText;
    }

    /**
     * 左边菜单栏内容
     * @return Component
     */
    private Component createLeftBar(){
        String[] btnsText = getMenuBtnText();
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
        sp.setRightComponent(new Index());
        this.add(sp);
    }


    /**
     * 创建窗口组件到右边
     * @param flag
     */
    private void createNewFrame(String flag){
        String componentsName = (String)Config.MENU_BTNS.get(flag);
        try {
            Class ComponentClass = Class.forName(componentsName);
            Component component = (Component)ComponentClass.newInstance();
            sp.setRightComponent(component);
            sp.setDividerLocation(Config.LEFT_BAR_WEIGHT);
        } catch (ClassNotFoundException e) {

            System.out.println("配置信息错误 组件未找到");
        } catch (IllegalAccessException e) {
            System.out.println("实例化右侧组件失败");
        } catch (InstantiationException e) {
            System.out.println("实例化右侧组件失败 该组件不是Component");
        }


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

