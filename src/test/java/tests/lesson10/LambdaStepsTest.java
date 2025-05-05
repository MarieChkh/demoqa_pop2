package tests.lesson10;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {
    private static final String REPO = "selenide/selenide";
    private static final String ISSUE = "Add conditions for collection size";

    @Test
    public void testIssueTitleWithLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> open("https://github.com"));
        step("Ищем репозиторий " + REPO, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(REPO).pressEnter();
        });
        step("Переходим в репозиторий " + REPO, () -> $(byLinkText(REPO)).click());
        step("Открываем вкладку Issues", () -> $("#issues-tab").click());
        step("Проверяем наличие Issue с заголовком '" + ISSUE + "'", () ->
                $("#issues-tab").shouldHave(text("Issues"))
        );
    }
}
