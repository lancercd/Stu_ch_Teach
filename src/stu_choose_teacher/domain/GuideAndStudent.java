package stu_choose_teacher.domain;

import java.util.List;
import java.util.Vector;

/**
 * 指导老师以及已经选择的学生信息
 */
public class GuideAndStudent {
    GuideAdviser guideAdviser;
    List<Student> students;

    public GuideAdviser getGuideAdviser() {
        return guideAdviser;
    }

    public void setGuideAdviser(GuideAdviser guideAdviser) {
        this.guideAdviser = guideAdviser;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "GuideAndStudent{" +
                "guideAdviser=" + guideAdviser +
                ", students=" + students +
                '}';
    }


    public Vector<Object> dataFormat(){
        Vector<Object> data = new Vector<Object>();
        data.add(guideAdviser.getTeacher_number());
        data.add(guideAdviser.getTeacher_name());
        for(Student stu : students){
            data.add(stu.getStu_name());
        }
        return data;

    }
}
