import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoPracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";


    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        //убираем рекламу
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        //Заполняем Name
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Rozhkova");

        //зааполняем E-mail
        $("#userEmail").setValue("ex@adress.com");

        //выбираем гендер
        $$("label").findBy(text("Female")).click();


        //заполняем телефон
        $("#userNumber").setValue("9325566047");

        //выбираем дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1991");
        $$(".react-datepicker__day").findBy(text("4")).click();

        //выбираем предметы
        $("#subjectsInput").setValue("Mat");
        $("#react-select-2-option-0").click();

        //выбираем хобби
        $("label[for='hobbies-checkbox-1']").click();

        // выбираем файл
        $("#uploadPicture").uploadFromClasspath("test.png");

        //блок адрес
        $("#currentAddress").setValue("Russia, Orenburg");

        //блок штат и город
        $("#state").scrollIntoView(true).click();
        $("#react-select-3-option-0").click();

        $("#city").click();
        $("#react-select-4-option-0").click();

        // нажимаем подтвердить
        $("#submit").scrollIntoView(true).click();

        //проверяем что в модальном окне наши введенные данные
        $(".table-responsive")
                .$(byText("Student Name"))
                .parent()
                .$("td", 1)
                .shouldHave(text("Anna Rozhkova"));

        $(".table-responsive")
                .$(byText("Student Email"))
                .parent()
                .$("td", 1)
                .shouldHave(text("ex@adress.com"));

        $(".table-responsive")
                .$(byText("Gender"))
                .parent()
                .$("td", 1)
                .shouldHave(text("Female"));

        $(".table-responsive")
                .$(byText("Mobile"))
                .parent()
                .$("td", 1)
                .shouldHave(text("9325566047"));

        $(".table-responsive")
                .$(byText("Date of Birth"))
                .parent()
                .$("td", 1)
                .shouldHave(text("04 June,1991"));

        $(".table-responsive")
                .$(byText("Subjects"))
                .parent()
                .$("td", 1)
                .shouldHave(text("Maths"));

        $(".table-responsive")
                .$(byText("Hobbies"))
                .parent()
                .$("td", 1)
                .shouldHave(text("Sports"));

        $(".table-responsive")
                .$(byText("Picture"))
                .parent()
                .$("td", 1)
                .shouldHave(text("test.png"));

        $(".table-responsive")
                .$(byText("Address"))
                .parent()
                .$("td", 1)
                .shouldHave(text("Russia, Orenburg"));

        $(".table-responsive")
                .$(byText("State and City"))
                .parent()
                .$("td", 1)
                .shouldHave(text("NCR Delhi"));


    }
}