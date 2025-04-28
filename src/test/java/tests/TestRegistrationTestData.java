package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.TestData;


public class TestRegistrationTestData extends TestDemoqa {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    @Test
    void successRegistrationTest() {
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
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submitForm();

        registrationFormPage.shouldAppear();

       }

    @Test
    void successfulMiniFieldsTest() {
        registrationFormPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setPhone(testData.userNumber)
                .selectGender(testData.gender)
                .submitForm();

        registrationFormPage.shouldAppear();
    }

    @Test
    void withoutRequiredFieldsTest() {
        registrationFormPage
                .openPage()
                .submitForm();

        registrationFormPage.shouldNotAppear();
    }
}