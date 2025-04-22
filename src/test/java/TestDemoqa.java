import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestDemoqa {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // defolt 4000
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("Marie");
        $("#lastName").setValue("Pichugina");
        $("#userEmail").setValue("masha@mail.ru");
        $("input[value=Female]").ancestor(".custom-radio").click();
        ;
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1981");
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__day--0" + "30").click();
        $("#subjectsInput").scrollTo();
        $("#subjectsInput").setValue("Biolo");
        $("#react-select-2-option-0").click();
        $("#hobbiesWrapper").$(byText("Music")).ancestor(".custom-checkbox").click();
        $("#uploadPicture").uploadFromClasspath("avatar.png");
        $("#currentAddress").setValue("Address");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $(".table-responsive").shouldHave(text("Marie Pichugina"));
        $(".table-responsive").shouldHave(text("masha@mail.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("30 November,1981"));
        $(".table-responsive").shouldHave(text("Biology"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("avatar.png"));
        $(".table-responsive").shouldHave(text("Address"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }
}

