package stu_choose_teacher.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import stu_choose_teacher.domain.GuideAdviser;
import stu_choose_teacher.domain.Student;
import stu_choose_teacher.utils.JDBCUtils;

import java.util.List;

public class StudentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据导师id 在导师学生表中 查询 已经选择了的学生信息
     * @param guide_adviser_id 指导老师id
     * @return 学生信息
     */
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

    /**
     * 根据学生id查找学生信息
     * @param stu_id 学生id
     * @return 学生信息
     */
    public Student getStudent(int stu_id){
        String sql = "select * from tb_jk2_student where stu_id = ?";

        Student student = template.queryForObject(sql,
                new BeanPropertyRowMapper<Student>(Student.class),
                stu_id);

        return student;
    }

    /**
     *
     * @param guide_adviser_id 指导老师id
     * @return
     */
    public boolean checkStudentByGuide(int guide_adviser_id, int stu_id){
        String sql = "select count(*) as row_count from tb_jk2_tutor_stu\n" +
                "where stu_id = ? and guide_adviser_id = ?;";

        SqlRowSet count = template.queryForRowSet(sql,
                stu_id, guide_adviser_id);

        int row_count = 0;
        if(count.next()){
            row_count = count.getInt("row_count");
        }

        if(row_count == 0){
            return false;
        }else{
            return true;
        }
    }
}
