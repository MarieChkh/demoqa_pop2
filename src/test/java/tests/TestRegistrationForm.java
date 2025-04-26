package tests;

import pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;
import pages.components.CheckResultComponent;

public class TestRegistrationForm extends TestDemoqa {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    CheckResultComponent checkResultComponent = new CheckResultComponent();


        String firstName = "Marie";
        String lastName = "Pichugina";
        String userEmail = "masha@mail.ru";
        String gender = "Female";
        String userNumber = "1234567890";
        String month = "November";
        String year = "1981";
        String day = "30";
        String subject = "Biolo";
        String hobbies = "Music";
        String uploadImage = "avatar.png";
        String currentAddress = "Address";
        String state = "NCR";
        String city = "Delhi";

        @Test
        void successRegistrationTest() {
            registrationFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(userEmail)
                    .setPhone(userNumber)
                    .selectGender(gender)
                    .setDateOfBirth(day, month, year)
                    .selectSubject(subject)
                    .selectHobby(hobbies)
                    .uploadPicture(uploadImage)
                    .setCurrentAddress(currentAddress)
                    .setState(state)
                    .setCity(city)
                    .submitForm();

            checkResultComponent.shouldAppear();

            registrationFormPage
                        .checkModalTitle("Thanks for submitting the form")
                        .checkResult(firstName + " " + lastName)
                        .checkResult(userEmail)
                        .checkResult( gender)
                        .checkResult( userNumber)
                        .checkResult( day + " " + month + "," + year)
                        .checkResult( subject)
                        .checkResult( hobbies)
                        .checkResult( uploadImage)
                        .checkResult( currentAddress)
                        .checkResult( state + " " + city);
            }

            @Test
            void successfulMiniFieldsTest() {
                registrationFormPage
                        .openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setPhone(userNumber)
                        .selectGender(gender)
                        .submitForm();

                checkResultComponent.shouldAppear();

                registrationFormPage
                        .checkModalTitle("Thanks for submitting the form")
                        .checkResult(firstName + " " + lastName)
                        .checkResult(gender)
                        .checkResult( userNumber);
            }

            @Test
            void withoutRequiredFieldsTest() {
                registrationFormPage
                        .openPage()
                        .submitForm();

                checkResultComponent.shouldNotAppear();
            }
        }

