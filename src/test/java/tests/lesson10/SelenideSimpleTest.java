package tests.lesson10;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSimpleTest {
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").setValue("selenide/selenide").pressEnter();
        $(byLinkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $("#issues-tab").shouldHave(text("Issues"));
    }
}
