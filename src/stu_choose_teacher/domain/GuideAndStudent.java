package stu_choose_teacher.domain;

import java.util.List;

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
}
