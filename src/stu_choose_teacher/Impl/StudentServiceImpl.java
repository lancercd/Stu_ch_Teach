package stu_choose_teacher.Impl;


import org.springframework.jdbc.core.JdbcTemplate;
import stu_choose_teacher.dao.GuideAdviserDao;
import stu_choose_teacher.dao.SemesterDao;
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
    public List<GuideAndStudent> getGuideAndStudentsBySemester(Semester semester){
        // 根据 学期 得到所有指导老师
        GuideAdviserDao guideAdviserDao = new GuideAdviserDao();
        StudentDao studentDao = new StudentDao();

        List<GuideAndStudent> guideAndStudents = new ArrayList<GuideAndStudent>();

        List<GuideAdviser> guideAdvisers = guideAdviserDao.getGuideAdvisers(semester);

        // 根据指导教师 通过导师学生表 搜索 已经选择的学生信息
        for(GuideAdviser guideAdviser : guideAdvisers){
            GuideAndStudent guideAndStudent = new GuideAndStudent();
            guideAndStudent.setGuideAdviser(guideAdviser);
            guideAndStudent.setSemester(semester);
            List<Student> studentsByGuide = studentDao.getStudentsByGuide(guideAdviser.getGuide_adviser_id());
            guideAndStudent.setStudents(studentsByGuide);
            guideAndStudents.add(guideAndStudent);
        }

        return guideAndStudents;
    }

    /**
     * 查询所有学期，指导教师信息以及已经选择学生的信息
     * @return
     */
    public List<GuideAndStudent> getGuideAndStudents(){
        List<Semester> semesters = new SemesterDao().getAllSemesters();
        StudentServiceImpl studentService = new StudentServiceImpl();
        List<GuideAndStudent> guideAndStudentList = new ArrayList<GuideAndStudent>();

        for(Semester semester : semesters){
            List<GuideAndStudent> guideAndStudentsBySemester = studentService.getGuideAndStudentsBySemester(semester);
            guideAndStudentList.addAll(guideAndStudentsBySemester);
        }

        return guideAndStudentList;
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

    /**
     * 学生选择指导教师
     * 选择时可填写自我介绍
     * 选择后可使用短信或邮件通知教师
     * @param stu_id    学生表id
     * @param guide_adviser_id  指导老师表id
     * @param stu_self_introduce    自我介绍
     * @param email_notice_guide_teacher    邮件通知指导教师（默认0）
     * @param message_notice_guide_teacher  短信通知指导教师（默认0）
     * @param notice_guide_teacher_content  通知指导教师内容
     */
    public void chooseGuide(int stu_id,int guide_adviser_id,String stu_self_introduce,int email_notice_guide_teacher,
                            int message_notice_guide_teacher, String notice_guide_teacher_content){
        TutorStu tutorStu = new TutorStu();
        TutorStuDao tutorStuDao = new TutorStuDao();

        tutorStu.setStu_id(stu_id);
        tutorStu.setGuide_adviser_id(guide_adviser_id);
        tutorStu.setStu_self_introduce(stu_self_introduce);
        tutorStu.setEmail_notice_guide_teacher(email_notice_guide_teacher);
        tutorStu.setMessage_notice_guide_teacher(message_notice_guide_teacher);
        tutorStu.setNotice_guide_teacher_content(notice_guide_teacher_content);
        tutorStu.setRead_teacher_id(-1);

        tutorStuDao.addTutorStu(tutorStu);
    }

    /**
     * 修改 导师学生表 记录，根据导师学生表id
     * @param tutor_stu_id  导师学生表id
     * @param tutorStu      导师学生表类
     */
    public void updateTutorStu(int tutor_stu_id, TutorStu tutorStu){
        TutorStuDao tutorStuDao = new TutorStuDao();
        tutorStuDao.updateTutorStu(tutor_stu_id, tutorStu);
    }

    /**
     * 删除 导师学生表 记录，根据导师学生表id
     * @param tutor_stu_id  导师学生表id
     */
    public void deleteTutorStu(int tutor_stu_id){
        TutorStuDao tutorStuDao = new TutorStuDao();
        tutorStuDao.deleteTutorStu(tutor_stu_id);
    }
}
