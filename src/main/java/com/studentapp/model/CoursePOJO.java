package com.studentapp.model;

public class CoursePOJO {
    public String course1;
    public String course2;

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public static CoursePOJO getCourse(String course1, String course2){
        CoursePOJO coursePOJO = new CoursePOJO();
        coursePOJO.setCourse1(course1);
        coursePOJO.setCourse2(course2);

        return coursePOJO;
    }
}
