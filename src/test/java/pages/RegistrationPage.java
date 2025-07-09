package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitTab = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;

    }

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();


        public RegistrationPage setFirstName (String value) {
            firstNameInput.setValue(value);

            return this;
        }

        public RegistrationPage setLastName(String value) {
            lastNameInput.setValue(value);

            return this;
        }

        public RegistrationPage setEmail(String value) {
            emailInput.setValue(value);

            return this;
        }

        public RegistrationPage setGender(String value) {
            genderInput.$(byText(value)).click();

            return this;
        }

        public RegistrationPage setUserNumber(String value) {
            numberInput.setValue(value);

            return this;
        }

        public RegistrationPage setDateOfBirth(String day, String month, String year) {
            dateOfBirthInput.click();
            calendarComponent.setDate(day, month, year);

            return this;
        }

        public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
        }

        public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
        }

        public RegistrationPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
        }

        public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
        }

        public RegistrationPage setStateInput (String value) {
            stateInput.click();
            stateCityWrapper.$(byText(value)).click();
            return this;
        }

        public RegistrationPage setCityInput (String value) {
            cityInput.click();
            stateCityWrapper.$(byText(value)).click();
        return this;
        }

        public RegistrationPage setSubmit () {
        submitTab.click();
        return this;
        }

    public RegistrationPage verifyResultsModalAppears() {
        resultTableComponent.verifyModalAppears();

        return this;
        }

    public RegistrationPage verifyResult(String key, String value) {
        resultTableComponent.verifyResult(key, value);

        return this;
    }

    public RegistrationPage verifyResultsModalAppearsNeg() {
        resultTableComponent.verifyModalAppearsNegative();

        return this;
    }
}






