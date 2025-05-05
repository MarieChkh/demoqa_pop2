package tests.lesson10;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotationStepsTest {
    private static final String REPO = "selenide/selenide";
    private static final String ISSUE = "Add conditions for collection size";
    WebSteps webSteps = new WebSteps();

    @Test
    public void testIssueTitleWithAnnotations() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        webSteps.
                openMainPage()
                .searchForRepository(REPO)
                .openRepository(REPO)
                .openIssuesTab()
        .shouldSeeIssueWithTitle(ISSUE);
        }
}
