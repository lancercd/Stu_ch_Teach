package stu_choose_teacher.dao;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import stu_choose_teacher.domain.GuideAdviser;
import stu_choose_teacher.domain.Semester;
import stu_choose_teacher.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class GuideAdviserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 按学期，查找所有指导教师
     * @param semester
     * @return
     */
    public List<GuideAdviser> getGuideAdvisers(Semester semester){
        String sql = "select guide_adviser_id, tb_jk2_guide_adviser.semester_id, tb_jk2_guide_adviser.stu_id,\n" +
                "email_notice, message_notice, notice_content, guide_adviser_affirm, guide_adviser_demand,\n" +
                "teacher_number, teacher_name\n" +
                "from tb_jk2_guide_adviser \n" +
                "join tb_jk2_semester \n" +
                "on tb_jk2_guide_adviser.semester_id = tb_jk2_semester.semester_id\n" +
                "join tb_jk2_teacher\n" +
                "on tb_jk2_teacher.teacher_id = tb_jk2_guide_adviser.stu_id\n" +
                "where tb_jk2_semester.semester_id = ?;";

        List<GuideAdviser> guideAdvisers = template.query(sql,
                new BeanPropertyRowMapper<GuideAdviser>(GuideAdviser.class),
                semester.getSemester_id());

        return guideAdvisers;
    }
}
