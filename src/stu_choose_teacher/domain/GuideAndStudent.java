package stu_choose_teacher.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * 指导老师以及已经选择的学生信息
 */
public class GuideAndStudent {
    GuideAdviser guideAdviser;
    List<Student> students;
    Semester semester;

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

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "GuideAndStudent{" +
                "guideAdviser=" + guideAdviser +
                ", students=" + students +
                ", semester=" + semester +
                '}';
    }

    public Vector<Object> dataFormat(){
        Vector<Object> data = new Vector<Object>();
        Vector<String> stuNames = new Vector<String>();
        data.add(guideAdviser.getGuide_adviser_id());
        data.add(guideAdviser.getTeacher_number());
        data.add(guideAdviser.getTeacher_name());

        for(Student stu : students){
            stuNames.add(stu.getStu_name());
        }
        data.add(String.join("," , stuNames));
        return data;

    }
}
