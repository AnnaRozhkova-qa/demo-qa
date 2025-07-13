package pages.components;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
public SelenideElement modalAppear = $(".modal-content"),
        modalResult = $(".table-responsive");
        public void verifyModalAppears() {
            modalAppear.shouldHave(text("Thanks for submitting the form"));
        }

        public void verifyResult(String key, String value) {
            modalResult.$(byText(key))
                    .parent().shouldHave(text(value));
        }

        public void verifyModalAppearsNegative() {
            modalAppear.shouldNotBe(visible);
        }
    }

