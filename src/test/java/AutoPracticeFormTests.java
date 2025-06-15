import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutoPracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");


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
        $(".table-responsive").
                shouldHave(
                        text("Anna Rozhkova"),
                        text("ex@adress.com"),
                        text("Female"),
                        text("9325566047"),
                        text("04 June,1991"),
                        text("Maths"),
                        text("Sports"),
                        text("test.png"),
                        text("Russia, Orenburg"),
                        text("NCR Delhi")
                );

    }
}