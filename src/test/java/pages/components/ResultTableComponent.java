package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

        public void verifyModalAppears() {
            $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        }

        public void verifyResult(String key, String value) {
            $(".table-responsive").$(byText(key))
                    .parent().shouldHave(text(value));
        }

        public void verifyModalAppearsNegative() {
            $(".modal-content").shouldNotBe(visible);
        }
    }

