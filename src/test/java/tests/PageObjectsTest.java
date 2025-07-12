package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static data.TestData.*;


public class PageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulPracticeFormTest (){

        registrationPage.openPage()
        .setFirstName(firstName)
        .setLastName(lastName)
        .setEmail(userEmail)
        .setGender(userGender)
        .setUserNumber(userNumber)
        .setDateOfBirth(userDay,userMonth,userYear)
        .setSubjects(userSubject)
        .setHobbies(userHobbies)
        .uploadPicture(userPicture)
        .setAddress(userAddress)
        .setStateInput(userState)
        .setCityInput(userCity)
        .setSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", userDay + " " + userMonth + ","+ userYear)
                .verifyResult("Subjects", userSubject)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", userPicture)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState+" "+userCity);
        }

    @Test
    void negativeMinFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber("")
                .setSubmit();

        registrationPage.verifyResultsModalAppearsNeg();
    }

}


