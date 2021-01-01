package stu_choose_teacher.domain;

public class ChooseMessage {
    private GuideAdviser guideAdviser;
    private TutorStu tutorStu;

    public GuideAdviser getGuideAdviser() {
        return guideAdviser;
    }

    public void setGuideAdviser(GuideAdviser guideAdviser) {
        this.guideAdviser = guideAdviser;
    }

    public TutorStu getTutorStu() {
        return tutorStu;
    }

    public void setTutorStu(TutorStu tutorStu) {
        this.tutorStu = tutorStu;
    }

    @Override
    public String toString() {
        return "ChooseMessage{" +
                "guideAdviser=" + guideAdviser +
                ", tutorStu=" + tutorStu +
                '}';
    }
}
