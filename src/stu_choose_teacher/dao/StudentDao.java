package stu_choose_teacher.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import stu_choose_teacher.domain.GuideAdviser;
import stu_choose_teacher.domain.Student;
import stu_choose_teacher.utils.JDBCUtils;

import java.util.List;

public class StudentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Student> getStudentsByGuide(int guide_adviser_id){
        String sql = "select tb_jk2_tutor_stu.stu_id, stu_number, stu_name, stu_password \n" +
                "from tb_jk2_tutor_stu \n" +
                "join tb_jk2_student\n" +
                "on tb_jk2_student.stu_id = tb_jk2_tutor_stu.stu_id\n" +
                "where guide_adviser_id = ?;";

        List<Student> students = template.query(sql,
                new BeanPropertyRowMapper<Student>(Student.class),
                guide_adviser_id);

        return students;
    }
}
