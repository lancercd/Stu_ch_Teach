package stu_choose_teacher.Impl;

import org.springframework.jdbc.core.JdbcTemplate;
import stu_choose_teacher.dao.GuideAdviserDao;
import stu_choose_teacher.dao.StudentDao;
import stu_choose_teacher.domain.GuideAdviser;
import stu_choose_teacher.domain.GuideAndStudent;
import stu_choose_teacher.domain.Semester;
import stu_choose_teacher.domain.Student;
import stu_choose_teacher.utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据学期，查看所有指导教师以及已经选择的学生信息
     * @param semester
     * @return
     */
    public List<GuideAndStudent> getGuideAndStudents(Semester semester){
        // 根据 学期 得到所有指导老师
        GuideAdviserDao guideAdviserDao = new GuideAdviserDao();
        StudentDao studentDao = new StudentDao();

        List<GuideAndStudent> guideAndStudents = new ArrayList<GuideAndStudent>();

        List<GuideAdviser> guideAdvisers = guideAdviserDao.getGuideAdvisers(semester);

        // 根据指导教师 通过导师学生表 搜索 已经选择的学生信息
        for(GuideAdviser guideAdviser : guideAdvisers){
            GuideAndStudent guideAndStudent = new GuideAndStudent();
            guideAndStudent.setGuideAdviser(guideAdviser);
            List<Student> studentsByGuide = studentDao.getStudentsByGuide(guideAdviser.getGuide_adviser_id());
            guideAndStudent.setStudents(studentsByGuide);
            guideAndStudents.add(guideAndStudent);
        }

        return guideAndStudents;
    }
}
