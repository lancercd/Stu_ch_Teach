package stu_choose_teacher.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import stu_choose_teacher.domain.Semester;
import stu_choose_teacher.utils.JDBCUtils;

import java.util.List;

public class SemesterDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Semester> getAllSemesters(){
        String sql = "select * from tb_jk2_semester";

        List<Semester> semesters = template.query(sql,
                new BeanPropertyRowMapper<Semester>(Semester.class));

        return semesters;
    }

    public static void main(String[] args) {
        List<Semester> allSemesters = new SemesterDao().getAllSemesters();

        System.out.println(allSemesters);
    }
}
