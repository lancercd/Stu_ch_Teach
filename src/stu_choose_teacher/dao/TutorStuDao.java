package stu_choose_teacher.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import stu_choose_teacher.domain.TutorStu;
import stu_choose_teacher.utils.JDBCUtils;

import java.util.List;

public class TutorStuDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据 学生id 查找所有的导师学生表记录
     * @param stu_id
     * @return
     */
    public List<TutorStu> getTutorStus(int stu_id){
        String sql = "select * from tb_jk2_tutor_stu where stu_id = ?";

        List<TutorStu> tutorStus = template.query(sql,
                new BeanPropertyRowMapper<TutorStu>(TutorStu.class),
                stu_id);

        return tutorStus;
    }

    /**
     * 添加记录 到 导师学生表
     * @param tutorStu
     */
    public void addTutorStu(TutorStu tutorStu){
        String sql = "insert into tb_jk2_tutor_stu\n" +
                "(tutor_stu_id,guide_adviser_id,stu_id,stu_self_introduce,email_notice_guide_teacher,\n" +
                "message_notice_guide_teacher,notice_guide_teacher_content,guide_teacher_check,\n" +
                "email_notice_stu,message_notice_stu,notice_stu_content,read_teacher_id,\n" +
                "email_notice_read_teacher,message_notice_read_teacher,notice_read_teacher_content) \n" +
                "VALUES\n" +
                "(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        template.update(sql,tutorStu.getGuide_adviser_id(),tutorStu.getStu_id(),tutorStu.getStu_self_introduce(),
                tutorStu.getEmail_notice_guide_teacher(),tutorStu.getMessage_notice_guide_teacher(),
                tutorStu.getNotice_guide_teacher_content(),tutorStu.getGuide_teacher_check(),
                tutorStu.getEmail_notice_stu(),tutorStu.getMessage_notice_stu(),
                tutorStu.getNotice_stu_content(),tutorStu.getRead_teacher_id(),
                tutorStu.getEmail_notice_read_teacher(),tutorStu.getMessage_notice_read_teacher(),
                tutorStu.getNotice_read_teacher_content());
    }

    /**
     * 修改表 tutorStu，根据表id
     * @param tutorStu
     */
    public void updateTutorStu(int tutor_stu_id, TutorStu tutorStu){
        String sql = "update tb_jk2_tutor_stu " +
                "set stu_self_introduce=?,email_notice_guide_teacher=?," +
                "message_notice_guide_teacher=?,notice_guide_teacher_content=?," +
                "guide_teacher_check=?,email_notice_stu=?,message_notice_stu=?," +
                "notice_stu_content=?,read_teacher_id=?,email_notice_read_teacher=?," +
                "message_notice_read_teacher=?,notice_read_teacher_content=?" +
                "where tutor_stu_id = ?";
        template.update(sql,tutorStu.getStu_self_introduce(),
                tutorStu.getEmail_notice_guide_teacher(),tutorStu.getMessage_notice_guide_teacher(),
                tutorStu.getNotice_guide_teacher_content(),tutorStu.getGuide_teacher_check(),
                tutorStu.getEmail_notice_stu(),tutorStu.getMessage_notice_stu(),
                tutorStu.getNotice_stu_content(),tutorStu.getRead_teacher_id(),
                tutorStu.getEmail_notice_read_teacher(),tutorStu.getMessage_notice_read_teacher(),
                tutorStu.getNotice_read_teacher_content(),tutor_stu_id);
    }

    public TutorStu getTutorStu(int tutor_stu_id, int guide_adviser_id, int stu_id, String stu_self_introduce,
                                int email_notice_guide_teacher, int message_notice_guide_teacher,
                                String notice_guide_teacher_content, int guide_teacher_check){
        TutorStu tutorStu = new TutorStu();

        tutorStu.setTutor_stu_id(tutor_stu_id);
        tutorStu.setGuide_adviser_id(guide_adviser_id);
        tutorStu.setStu_id(stu_id);
        tutorStu.setStu_self_introduce(stu_self_introduce);
        tutorStu.setEmail_notice_guide_teacher(email_notice_guide_teacher);
        tutorStu.setMessage_notice_guide_teacher(message_notice_guide_teacher);
        tutorStu.setNotice_guide_teacher_content(notice_guide_teacher_content);
        tutorStu.setGuide_teacher_check(guide_teacher_check);
        tutorStu.setRead_teacher_id(-1);

        return tutorStu;
    }

    /**
     * 删除表tutorStu记录，根据表id
     * @param tutor_stu_id
     */
    public void deleteTutorStu(int tutor_stu_id){
        String sql = "delete FROM tb_jk2_tutor_stu where tutor_stu_id = ?";

        template.update(sql,tutor_stu_id);
    }
}
