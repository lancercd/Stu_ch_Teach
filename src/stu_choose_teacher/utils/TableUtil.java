package stu_choose_teacher.utils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TableUtil {
    public static void tableFace(JTable table){
        JTableHeader head = table.getTableHeader(); // 创建表格标题对象
        head.setPreferredSize(new Dimension(head.getWidth(), 45));// 设置表头大小
        head.setFont(new Font("黑体", Font.BOLD, 18));// 设置表格字体
        head.setBackground(new Color(52, 152, 219));
        head.setForeground(new Color(255,255,255));
        table.setRowHeight(35);
        table.setFont(new Font("宋体", Font.PLAIN, 20));
    }
}
