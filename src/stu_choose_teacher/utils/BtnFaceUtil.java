package stu_choose_teacher.utils;

import javax.swing.*;
import java.awt.*;

public class BtnFaceUtil {
    public static void btnFace(JButton btn, Color bg, Color fontColor){
        btn.setFont(new Font("Aria",Font.BOLD,20));
        btn.setBackground(bg);
        btn.setForeground(fontColor);
//        btn.setBorder(null);
    }

}
