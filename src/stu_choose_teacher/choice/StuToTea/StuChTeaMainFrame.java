package stu_choose_teacher.choice.StuToTea;

import stu_choose_teacher.choice.StuToTea.components.Index;
import stu_choose_teacher.config.Config;
import stu_choose_teacher.dao.StudentDao;
import stu_choose_teacher.domain.Student;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class StuChTeaMainFrame extends JFrame {
    JSplitPane sp = null;
    Student user = null;


    /**
     * 当前用户
     */
    public StuChTeaMainFrame(int stu_id){
        this.user = new StudentDao().getStudent(stu_id);
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
//        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
//        AWTUtilities.setWindowShape(this,
//                new RoundRectangle2D.Double(0.0D, 0.0D, this.getWidth(), this.getHeight(), 20.0D, 20.0D));
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
        JPanel jPanel = new JPanel();
//        Color base = new Color(52, 152, 219,50);
//        jPanel.setBackground(base);
        jPanel.setBackground(new Color(255,255,255));
        String[] btnsText = getMenuBtnText();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("管理");
        for(String text : btnsText){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(text);
            root.add(node);
        }
        JTree tree = new JTree(root);
        tree.setFont(new Font("宋体", Font.PLAIN, 24));
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

                createNewFrame(lastPathComponent.toString());
            }
        });
        tree.setBackground(new Color(255,255,255));
//        tree.setBackground(base);
        jPanel.add(tree);
        return jPanel;
    }

    private void conponentsInit(){

        //分为左右两边
        sp = new JSplitPane();
        sp.setContinuousLayout(true);
        sp.setDividerLocation(Config.LEFT_BAR_WEIGHT);
        sp.setDividerSize(Config.DIVIDER_SIZE);

//        JPanel rightBar = new JPanel();
//        sp.setBackground(new Color(52, 152, 219, 50));
        sp.setLeftComponent(createLeftBar());
//        CheckAllAdviser allAdviser = new CheckAllAdviser();
//        allAdviser.setCurrentUser(user);
//        allAdviser.init(this);
        sp.setRightComponent(new Index(user));

        this.add(sp);
    }


    /**
     * 创建窗口组件到右边
     * @param flag 窗体名
     */
    private void createNewFrame(String flag){
        String componentsName = (String)Config.MENU_BTNS.get(flag);
        if(componentsName == null) return;
        try {
            Class<?> ComponentClass = Class.forName(componentsName);
            Component component = (Component)ComponentClass.newInstance();

            Method serUsermethod = ComponentClass.getMethod("setCurrentUser", Student.class);
            Method initMethod = ComponentClass.getMethod("init", JFrame.class);

            serUsermethod.invoke(component, user);
            initMethod.invoke(component, this);

            sp.setRightComponent(component);
            sp.setDividerLocation(Config.LEFT_BAR_WEIGHT);
        } catch (ClassNotFoundException e) {

            System.out.println("配置信息错误 组件未找到");
        } catch (IllegalAccessException e) {
            System.out.println("实例化右侧组件失败");
        } catch (InstantiationException e) {
            System.out.println("实例化右侧组件失败 该组件不是Component");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }




    private int getLocationX(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-getWidth() / 2;
    }
    private int getLocationY(){
        return ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-getHeight() / 2;
    }




    public static void main(String[] args) {
//        try {
//            JFrame.setDefaultLookAndFeelDecorated(true);
//            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//            new StuChTeaMainFrame();
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }

        new StuChTeaMainFrame(1);
    }



    private class MenuBtnRenderer extends DefaultTreeCellRenderer {
        private Image rootIcon = null;

        public MenuBtnRenderer(){
//            rootIcon = ImageIO.read();
        }

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
//            this.setIcon(imageIcon);
            return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
//            this.setIcon(new ImageIcon("\\src\\stu_choose_teacher\\static\\index.png"));
        }
    }
}

