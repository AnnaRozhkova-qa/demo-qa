import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulPracticeFormTest (){
registrationPage.openPage()
        .setFirstName("Anna")
        .setLastName("Rozhkova")
        .setEmail("ex@adress.com")
        .setGender("Female")
        .setUserNumber("9325566047")
        .setDateOfBirth("4","June","1991")
        .setSubjects("Math")
        .setHobbies("Sports")
        .uploadPicture("test.png")
        .setAddress("Russia, Orenburg")
        .setStateInput("NCR")
        .setCityInput("Delhi")
        .setSubmit();

          registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", "Anna Rozhkova")
                .verifyResult("Student Email", "ex@adress.com")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "9325566047")
                .verifyResult("Date of Birth", "04 June,1991")
                .verifyResult("Subjects", "Math")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "test.png")
                .verifyResult("Address", "Russia, Orenburg")
                .verifyResult("State and City", "NCR Delhi");
        }

    @Test
    void negativeMinFormTest() {

        registrationPage.openPage()
                .setFirstName("Anna")
                .setLastName("Rozhkova")
                .setGender("Female")
                .setUserNumber("")
                .setSubmit();

        registrationPage.verifyResultsModalAppearsNeg();
    }

}


