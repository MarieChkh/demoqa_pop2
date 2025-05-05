package tests.lesson10;

import io.qameta.allure.Step;
import io.qameta.allure.Allure;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public WebSteps openMainPage() {
        open("https://github.com");

        return this;
    }

    @Step("Ищем репозиторий {repo}")
    public WebSteps searchForRepository(String repo) {
        $(".search-input").click();
        $("#query-builder-test").setValue(repo).pressEnter();

        return this;
    }

    @Step("Переходим в репозиторий {repo}")
    public WebSteps openRepository(String repo) {
        $(byLinkText(repo)).click();

            return this;
    }

    @Step("Открываем вкладку Issues")
    public WebSteps openIssuesTab() {
        $("[data-content=Issues]").click();
        return this;
    }

    @Step("Проверяем наличие Issue с заголовком '{title}'")
    public WebSteps shouldSeeIssueWithTitle(String title) {
        Allure.addAttachment("Проверяемый заголовок Issue", title);
        $("#issues-tab").shouldHave(text("Issues"));

        return this;
    }

}
