package stu_choose_teacher.domain;

import stu_choose_teacher.utils.FormData;

import java.util.Vector;

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

    public Vector<Object> dataFormat(){
        Vector<Object> data = new Vector<Object>();
        data.add(tutorStu.getTutor_stu_id());
        data.add(guideAdviser.getTeacher_number());
        data.add(guideAdviser.getTeacher_name());
        data.add((guideAdviser.getGuide_adviser_affirm() == 1)? "已确认" : "未确认");
        data.add(guideAdviser.getGuide_adviser_demand());
        data.add(FormData.check_notice_type(tutorStu.getMessage_notice_guide_teacher(), tutorStu.getEmail_notice_read_teacher()));
        data.add(guideAdviser.getNotice_content());
        data.add(tutorStu.getStu_self_introduce());
        data.add(FormData.notice_message_to_string(tutorStu.getMessage_notice_stu()));
        data.add(FormData.notice_message_to_string(tutorStu.getEmail_notice_stu()));
        return data;
    }
}
