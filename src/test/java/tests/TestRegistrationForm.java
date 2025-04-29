package tests;

import pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

public class TestRegistrationForm extends TestDemoqa {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


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

            registrationFormPage.shouldAppear();

            registrationFormPage
                        .checkModalTitle("Thanks for submitting the form")
                        .checkResultSimple(firstName + " " + lastName)
                        .checkResultSimple(userEmail)
                        .checkResultSimple( gender)
                        .checkResultSimple( userNumber)
                        .checkResultSimple( day + " " + month + "," + year)
                        .checkResultSimple( subject)
                        .checkResultSimple( hobbies)
                        .checkResultSimple( uploadImage)
                        .checkResultSimple( currentAddress)
                        .checkResultSimple( state + " " + city);
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

                registrationFormPage.shouldAppear();

                registrationFormPage
                        .checkModalTitle("Thanks for submitting the form")
                        .checkResultSimple(firstName + " " + lastName)
                        .checkResultSimple(gender)
                        .checkResultSimple( userNumber);
            }

            @Test
            void withoutRequiredFieldsTest() {
                registrationFormPage
                        .openPage()
                        .submitForm();

                registrationFormPage.shouldNotAppear();
            }
        }

