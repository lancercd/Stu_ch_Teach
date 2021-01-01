package stu_choose_teacher.domain;

/**
 * 导师学生表
 */
public class TutorStu {
    private int tutor_stu_id;       // id
    private int guide_adviser_id;   // 指导教师表ID
    private int stu_id;             // 学生ID
    private String stu_self_introduce;  // 学生自我介绍
    private int email_notice_guide_teacher; // 邮件通知指导教师
    private int message_notice_guide_teacher;   // 短信通知指导教师
    private String notice_guide_teacher_content;    // 通知指导教师内容
    private int guide_teacher_check;        // 指导教师审核
    private int email_notice_stu;           // 邮件通知学生
    private int message_notice_stu;         // 短信通知学生
    private String notice_stu_content;      // 通知学生内容
    private int read_teacher_id;            // 评审教师id
    private int email_notice_read_teacher;  // 邮件通知评阅教师
    private int message_notice_read_teacher;    // 短信通知评阅教师
    private String notice_read_teacher_content; // 通知评阅教师内容


    public int getTutor_stu_id() {
        return tutor_stu_id;
    }

    public void setTutor_stu_id(int tutor_stu_id) {
        this.tutor_stu_id = tutor_stu_id;
    }

    public int getGuide_adviser_id() {
        return guide_adviser_id;
    }

    public void setGuide_adviser_id(int guide_adviser_id) {
        this.guide_adviser_id = guide_adviser_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_self_introduce() {
        return stu_self_introduce;
    }

    public void setStu_self_introduce(String stu_self_introduce) {
        this.stu_self_introduce = stu_self_introduce;
    }

    public int getEmail_notice_guide_teacher() {
        return email_notice_guide_teacher;
    }

    public void setEmail_notice_guide_teacher(int email_notice_guide_teacher) {
        this.email_notice_guide_teacher = email_notice_guide_teacher;
    }

    public int getMessage_notice_guide_teacher() {
        return message_notice_guide_teacher;
    }

    public void setMessage_notice_guide_teacher(int message_notice_guide_teacher) {
        this.message_notice_guide_teacher = message_notice_guide_teacher;
    }

    public String getNotice_guide_teacher_content() {
        return notice_guide_teacher_content;
    }

    public void setNotice_guide_teacher_content(String notice_guide_teacher_content) {
        this.notice_guide_teacher_content = notice_guide_teacher_content;
    }

    public int getGuide_teacher_check() {
        return guide_teacher_check;
    }

    public void setGuide_teacher_check(int guide_teacher_check) {
        this.guide_teacher_check = guide_teacher_check;
    }

    public int getEmail_notice_stu() {
        return email_notice_stu;
    }

    public void setEmail_notice_stu(int email_notice_stu) {
        this.email_notice_stu = email_notice_stu;
    }

    public int getMessage_notice_stu() {
        return message_notice_stu;
    }

    public void setMessage_notice_stu(int message_notice_stu) {
        this.message_notice_stu = message_notice_stu;
    }

    public String getNotice_stu_content() {
        return notice_stu_content;
    }

    public void setNotice_stu_content(String notice_stu_content) {
        this.notice_stu_content = notice_stu_content;
    }

    public int getRead_teacher_id() {
        return read_teacher_id;
    }

    public void setRead_teacher_id(int read_teacher_id) {
        this.read_teacher_id = read_teacher_id;
    }

    public int getEmail_notice_read_teacher() {
        return email_notice_read_teacher;
    }

    public void setEmail_notice_read_teacher(int email_notice_read_teacher) {
        this.email_notice_read_teacher = email_notice_read_teacher;
    }

    public int getMessage_notice_read_teacher() {
        return message_notice_read_teacher;
    }

    public void setMessage_notice_read_teacher(int message_notice_read_teacher) {
        this.message_notice_read_teacher = message_notice_read_teacher;
    }

    public String getNotice_read_teacher_content() {
        return notice_read_teacher_content;
    }

    public void setNotice_read_teacher_content(String notice_read_teacher_content) {
        this.notice_read_teacher_content = notice_read_teacher_content;
    }

    @Override
    public String toString() {
        return "TutorStu{" +
                "tutor_stu_id=" + tutor_stu_id +
                ", guide_adviser_id=" + guide_adviser_id +
                ", stu_id=" + stu_id +
                ", stu_self_introduce='" + stu_self_introduce + '\'' +
                ", email_notice_guide_teacher=" + email_notice_guide_teacher +
                ", message_notice_guide_teacher=" + message_notice_guide_teacher +
                ", notice_guide_teacher_content='" + notice_guide_teacher_content + '\'' +
                ", guide_teacher_check=" + guide_teacher_check +
                ", email_notice_stu=" + email_notice_stu +
                ", message_notice_stu=" + message_notice_stu +
                ", notice_stu_content='" + notice_stu_content + '\'' +
                ", read_teacher_id=" + read_teacher_id +
                ", email_notice_read_teacher=" + email_notice_read_teacher +
                ", message_notice_read_teacher=" + message_notice_read_teacher +
                ", notice_read_teacher_content='" + notice_read_teacher_content + '\'' +
                '}';
    }
}
