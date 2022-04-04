package com.studentapp.cucumber.steps;

import com.studentapp.studentinfo.StudentSteps;
import com.studentapp.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefs {


    static String email;
    static int studentID;
    public static ValidatableResponse response;


    @Steps
    StudentSteps studentSteps;


    @When("^I create a new student record with \"([^\"]*)\", \"([^\"]*)\", 'email', \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iCreateANewStudentRecordWithEmailAnd(String firstName, String lastName, String programme,
                                                     String course1, String course2) {
        email = TestUtils.getRandomValue() + "@gmail.com";

        response = studentSteps.createStudent(firstName, lastName, email, programme, course1, course2);
        response.statusCode(201).log().ifValidationFails();
    }

    @And("^I can read the created record using 'email'$")
    public void iCanReadTheCreatedRecordUsingEmail() {
        HashMap<String, Object> record = studentSteps.readStudentByEmail(email);

        Assert.assertThat(record, hasValue(email));
        studentID = (int) record.get("id");
        System.out.println(studentID);
    }

    @And("^update the created record using studentID with PUT request and details \"([^\"]*)\" \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void updateTheCreatedRecordUsingStudentIDWithPUTRequestAndDetails(String firstName, String lastName, String programme,
                                                                             String course1, String course2) {
        email = "updated"+email;
        response = studentSteps.updateRecordWithEmail(studentID,firstName,lastName,email,programme,course1, course2);
        response.statusCode(200).log().all();

    }

    @And("^read updated record using studentID$")
    public void readUpdatedRecordUsingStudentID() {
        HashMap<String, Object> record = studentSteps.readStudentByEmail(email);

        Assert.assertThat(record, hasValue(email));
        System.out.println(email);
    }

    @And("^delete newly created record with same studentID$")
    public void deleteNewlyCreatedRecordWithSameStudentID() {
        response = studentSteps.deleteStudentWithID(studentID).statusCode(204);
    }

    @Then("^verify that no record can be found using same studentID$")
    public void verifyThatNoRecordCanBeFoundUsingSameStudentID() {
        response = studentSteps.readSingleStudentWithID(studentID).statusCode(404);
    }



}
