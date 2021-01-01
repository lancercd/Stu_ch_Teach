package stu_choose_teacher.domain;

/**
 * 学生信息tb_jk2_guide_adviser
 */
public class Student {
    private int stu_id;     // 学生表id
    private int stu_number; // 学号
    private String stu_name;    // 学生姓名
    private String stu_password;    // 学生密码

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getStu_number() {
        return stu_number;
    }

    public void setStu_number(int stu_number) {
        this.stu_number = stu_number;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_password() {
        return stu_password;
    }

    public void setStu_password(String stu_password) {
        this.stu_password = stu_password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_number=" + stu_number +
                ", stu_name='" + stu_name + '\'' +
                ", stu_password='" + stu_password + '\'' +
                '}';
    }
}
