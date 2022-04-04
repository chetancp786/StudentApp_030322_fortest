package com.studentapp.model;

import java.util.List;

public class StudentPOJO {
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private CoursePOJO coursePOJO;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public CoursePOJO getCoursePOJO() {
        return coursePOJO;
    }

    public void setCoursePOJO(CoursePOJO coursePOJO) {
        this.coursePOJO = coursePOJO;
    }

    public static StudentPOJO studentPOJO(String firstName, String lastName, String email,
                                          String programme, CoursePOJO coursePOJO){


    StudentPOJO studentPOJO = new StudentPOJO();
    studentPOJO.setFirstName(firstName);
    studentPOJO.setLastName(lastName);
    studentPOJO.setEmail(email);
    studentPOJO.setProgramme(programme);
    studentPOJO.setCoursePOJO(coursePOJO);
    return studentPOJO;

    }
}
