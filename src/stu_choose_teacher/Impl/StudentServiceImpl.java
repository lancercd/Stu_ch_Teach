package stu_choose_teacher.Impl;

import org.springframework.jdbc.core.JdbcTemplate;
import stu_choose_teacher.dao.GuideAdviserDao;
import stu_choose_teacher.dao.StudentDao;
import stu_choose_teacher.dao.TutorStuDao;
import stu_choose_teacher.domain.*;
import stu_choose_teacher.utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 根据学生id 查看 学生的选择信息
     * @param stu_id
     * @return
     */
    public List<ChooseMessage> getChooseMessage(int stu_id){
        // 根据 学生id 查询 导师学生表
        List<ChooseMessage> chooseMessages = new ArrayList<ChooseMessage>();

        TutorStuDao tutorStuDao = new TutorStuDao();
        List<TutorStu> tutorStus = tutorStuDao.getTutorStus(stu_id);
        GuideAdviserDao guideAdviserDao = new GuideAdviserDao();

        for(TutorStu tutorStu : tutorStus){
            ChooseMessage chooseMessage = new ChooseMessage();
            chooseMessage.setTutorStu(tutorStu);
            GuideAdviser guideAdviser = guideAdviserDao.getGuideAdviser(tutorStu.getGuide_adviser_id());
            chooseMessage.setGuideAdviser(guideAdviser);
            chooseMessages.add(chooseMessage);
        }

        return chooseMessages;
    }
}
