package stu_choose_teacher.domain;

import java.util.Vector;

/**
 * 指导教师表tb_jk2_guide_adviser
 */
public class GuideAdviser {
    private int guide_adviser_id;   // id
    private int semester_id;        // 学期表id
    private int stu_id;             // 教师表id
    private int email_notice;       // 邮件通知
    private int message_notice;     // 短信通知
    private String notice_content;  // 通知内容
    private int guide_adviser_affirm;   // 指导教师确认
    private String guide_adviser_demand;    // 指导教师要求
    private int teacher_number;     // 教师工号
    private String teacher_name;    // 教师姓名

    public int getGuide_adviser_id() {
        return guide_adviser_id;
    }

    public void setGuide_adviser_id(int guide_adviser_id) {
        this.guide_adviser_id = guide_adviser_id;
    }

    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getEmail_notice() {
        return email_notice;
    }

    public void setEmail_notice(int email_notice) {
        this.email_notice = email_notice;
    }

    public int getMessage_notice() {
        return message_notice;
    }

    public void setMessage_notice(int message_notice) {
        this.message_notice = message_notice;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public int getGuide_adviser_affirm() {
        return guide_adviser_affirm;
    }

    public void setGuide_adviser_affirm(int guide_adviser_affirm) {
        this.guide_adviser_affirm = guide_adviser_affirm;
    }

    public String getGuide_adviser_demand() {
        return guide_adviser_demand;
    }

    public void setGuide_adviser_demand(String guide_adviser_demand) {
        this.guide_adviser_demand = guide_adviser_demand;
    }

    public int getTeacher_number() {
        return teacher_number;
    }

    public void setTeacher_number(int teacher_number) {
        this.teacher_number = teacher_number;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    @Override
    public String toString() {
        return "GuideAdviser{" +
                "guide_adviser_id=" + guide_adviser_id +
                ", semester_id=" + semester_id +
                ", stu_id=" + stu_id +
                ", email_notice=" + email_notice +
                ", message_notice=" + message_notice +
                ", notice_content='" + notice_content + '\'' +
                ", guide_adviser_affirm=" + guide_adviser_affirm +
                ", guide_adviser_demand='" + guide_adviser_demand + '\'' +
                ", teacher_number=" + teacher_number +
                ", teacher_name='" + teacher_name + '\'' +
                '}';
    }
}
