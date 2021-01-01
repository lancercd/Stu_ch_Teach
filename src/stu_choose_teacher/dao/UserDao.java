package stu_choose_teacher.dao;

import stu_choose_teacher.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class UserDao {
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *
     * @param id
     * @return
     */
    public static User getUsername(int id){

        // 定义sql语句
        String sql = "select * from tb_tk_user where id = ?";

        // 执行sql语句

        User user = null;

        try{
            user = null;
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    id);
        } catch(DataAccessException e){
            e.printStackTrace();
            return null;
        }

        return user;
    }
}
