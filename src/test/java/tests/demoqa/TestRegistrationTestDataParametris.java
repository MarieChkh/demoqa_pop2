package tests.demoqa;

import data.CurrentAddress;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static com.codeborne.selenide.Selenide.$;

public class TestRegistrationTestDataParametris extends TestRegistrationTestData {

    @Tag("SMOKE")
    @ParameterizedTest(name = "Проверка регистрации со всеми полями и фамилией : {0}")
    @ValueSource(strings = {"Иванов", "Петров", "Сидоров"})
    void successRegistrationTestWithParametr(String lastNameParametrized) {
        registrationFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(lastNameParametrized)
                .setEmail(testData.userEmail)
                .setPhone(testData.userNumber)
                .selectGender(testData.gender)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .selectSubject(testData.subject)
                .selectHobby(testData.hobbies)
                .uploadPicture(testData.uploadImage)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submitForm();

        registrationFormPage.shouldAppear()
                .checkResult("Student Name", testData.firstName + " " + lastNameParametrized)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.uploadImage)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city);

       }

    @EnumSource(CurrentAddress.class)
    @ParameterizedTest(name = "Проверка формы регистрации с рандомными данными и константой в адресе")
    void TestCostantCurrentAddress(CurrentAddress currentAddress) {
        registrationFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setPhone(testData.userNumber)
                .selectGender(testData.gender)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .selectSubject(testData.subject)
                .selectHobby(testData.hobbies)
                .uploadPicture(testData.uploadImage)
                .setCurrentAddress(currentAddress.description)
                .setState(testData.state)
                .setCity(testData.city)
                .submitForm();

        registrationFormPage.shouldAppear()
        .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.uploadImage)
                .checkResult("Address", currentAddress.description)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Tag("SMOKE")
    @ParameterizedTest(name = "Проверка получения ошибки при регистрации без обязательных полей и именем {0}, фамилией {1}")
    @CsvFileSource(resources = "/person.csv")
    void unsuccessfulRegistrationWithoutRequiredFieldsTest(String firstName, String lastName) {

        registrationFormPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .submitForm();
        registrationFormPage.shouldNotAppear();
    }
}
