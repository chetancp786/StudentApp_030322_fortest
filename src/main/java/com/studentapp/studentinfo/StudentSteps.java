package com.studentapp.studentinfo;

import com.studentapp.constants.EndPoints;
import com.studentapp.model.CoursePOJO;
import com.studentapp.model.StudentPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

public class StudentSteps {

    @Step("Creating student with firstName:{0}, lastName:{1}, email:{2}, programme:{3}, courses:{4} and courses:{5}")
    public ValidatableResponse createStudent(String firstName, String lastName, String email,
                                             String programme, String course1, String course2) {
        CoursePOJO coursePOJO = CoursePOJO.getCourse(course1,course2);
        StudentPOJO studentPOJO = StudentPOJO.studentPOJO(firstName, lastName, email, programme, coursePOJO);
        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(studentPOJO)
                .when()
                .post()
                .then();
    }

    @Step("")
    public HashMap<String, Object> readStudentByEmail(String email){

       return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.LIST)
                .then().log().ifValidationFails()
                .extract()
                .path("findAll{it.email=='"+email+"'}.get(0)");
    }

    @Step("")
    public ValidatableResponse updateRecordWithEmail(int studentId,String firstName, String lastName, String email,
                                                     String programme, String course1, String course2){
        CoursePOJO coursePOJO = CoursePOJO.getCourse(course1,course2);
        StudentPOJO studentPOJO = StudentPOJO.studentPOJO(firstName, lastName, email, programme, coursePOJO);
        return SerenityRest.given()
                .pathParam("id", studentId)
                .contentType(ContentType.JSON)
                .body(studentPOJO)
                .when()
                .put(EndPoints.ID)
                .then();
    }

    @Step("")
    public ValidatableResponse deleteStudentWithID(int studentId){
        return SerenityRest.given()
                .pathParam("id", studentId)
                .when()
                .delete(EndPoints.ID)
                .then();
   }

    @Step("")
    public ValidatableResponse readSingleStudentWithID(int studentId){
        return SerenityRest.given()
                .pathParam("id", studentId)
                .when()
                .get(EndPoints.ID)
                .then();
    }

}
