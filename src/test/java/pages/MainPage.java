package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public void openMainPage() {
        open("/");
    }

    public void goToAboutPage() {
        $("a[href='/about/']").click();
    }

    public void goToProductsPage() {
        $("a[href='/products/']").click();
    }

    public void goToCarrerPage() {
        $("a[href='/career/']").click();
    }

    public void goToPartnersPage() {
        $("a[href='/partners/']").click();
    }

    public void checkPageHeader(String expectedHeaderText) {
        $("h1").shouldHave(text(expectedHeaderText));
    }

    public void checkTitle(String expectedTitle) {
        title().equals(expectedTitle);
    }
}
