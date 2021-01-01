package stu_choose_teacher.choice.StuToTea;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Test extends JFrame {


    public void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        JTabbedPane tab = new JTabbedPane(SwingConstants.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        tab.add("ok1", new JList<String>(new String[]{"111", "222"}));
        tab.add("ok2", new JList<String>(new String[]{"222", "222"}));
        tab.add("ok3", new JList<String>(new String[]{"333", "222"}));
        tab.add("ok4", new JList<String>(new String[]{"444", "222"}));

        tab.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectIndex = tab.getSelectedIndex();

            }
        });


        tab.setEnabledAt(0, false);
        tab.setSelectedIndex(1);
        this.add(tab);

        this.setBounds(400,400,400,400);


        this.setVisible(true);
    }




    public static void main(String[] args) {
        new Test().init();
    }
}
