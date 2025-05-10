package tests.demoqa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.TestData;


public class TestRegistrationTestData extends TestDemoqa {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    @Test
    @Tag("demoqa_properties")
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

        registrationFormPage.shouldAppear()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
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

    @Test
    @Tag("demoqa_properties")
    void successfulMiniFieldsTest() {
        registrationFormPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setPhone(testData.userNumber)
                .selectGender(testData.gender)
                .submitForm();
        registrationFormPage.shouldAppear()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber);
    }

    @Test
    @Tag("demoqa_properties")
    void withoutRequiredFieldsTest() {
        registrationFormPage
                .openPage()
                .submitForm();

        registrationFormPage.shouldNotAppear();
    }
}