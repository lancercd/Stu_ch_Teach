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
}
