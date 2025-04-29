package pages;

import pages.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

        CalendarComponent calendarComponent = new CalendarComponent();

        private static SelenideElement
                firstNameInput = $("#firstName"),
                lastNameInput = $("#lastName"),
                emailInput = $("#userEmail"),
                phoneInput = $("#userNumber"),
                genderInput = $("#genterWrapper"),
                dateOfBirthInput = $("#dateOfBirthInput"),
                subjectInput = $("#subjectsInput"),
                hobbiesInput = $("#hobbiesWrapper"),
                uploadPictureSelector = $("#uploadPicture"),
                currentAddressInput = $("#currentAddress"),
                stateInput = $("#state"),
                cityInput = $("#city"),
                submitButton = $("#submit"),
                modalContent = $(".modal-content"),
                modalTitle = $(".modal-title"),
                modalWindow = $(".modal-dialog");

        public RegistrationFormPage openPage() {
            open("/automation-practice-form");
            removeBanner();
            return this;
        }
        public RegistrationFormPage removeBanner() {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            return this;
        }

        public RegistrationFormPage setFirstName(String value) {
            firstNameInput.setValue(value);
            return this;
        }

        public RegistrationFormPage setLastName(String value) {
            lastNameInput.setValue(value);
            return this;
        }

        public RegistrationFormPage setEmail(String value) {
            emailInput.setValue(value);
            return this;
        }

        public RegistrationFormPage setPhone(String value) {
            phoneInput.setValue(value);
            return this;
        }

        public RegistrationFormPage selectGender(String value) {
            genderInput.$(byText(value)).click();
            return this;
        }

        public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
            dateOfBirthInput.click();
            calendarComponent.setDate(day, month, year);
            return this;
        }

        public RegistrationFormPage selectSubject(String value) {
            subjectInput.setValue(value).pressEnter();
            return this;
        }

        public RegistrationFormPage selectHobby(String value) {
            hobbiesInput.$(byText(value)).click();
            return this;
        }

        public RegistrationFormPage uploadPicture(String filePath) {
            uploadPictureSelector.uploadFromClasspath(filePath);
            return this;
        }

        public RegistrationFormPage setCurrentAddress(String imageName) {
            currentAddressInput.setValue(imageName);
            return this;
        }

        public RegistrationFormPage setState(String value) {
            stateInput.click();
            $(byText(value)).click();
            return this;
        }

        public RegistrationFormPage setCity(String value) {
            cityInput.click();
            $(byText(value)).click();
            return this;
        }

        public void submitForm() {
            submitButton.click();
        }

        public RegistrationFormPage checkResultSimple(String  value) {
            modalContent.shouldHave(text(value));
            return this;
        }

        public  RegistrationFormPage checkResult(String key, String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;

        }

            public RegistrationFormPage checkModalTitle(String title) {
            modalTitle.shouldHave(text(title));
            return this;
        }
//
            public RegistrationFormPage shouldAppear() {
                modalWindow.should(appear);
                return this;
            }
            public void shouldNotAppear() {
                modalWindow.shouldNot(appear);
            }

        }