package com.PageObject;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

public class RegistrationTest {

    @Before
    public void setUp (){
        Configuration.startMaximized = true;
    }
    @After
    public void tearDown (){
        webdriver().driver().close();
    }

    @DisplayName("Успешная регистрация с паролем 6 символов")
    @Test
    public void SuccessfulRegistration() {
        UserData user = UserData.getRandom(6);
        RegisterFormPage registerFormPage =  open(RegisterFormPage.URL, RegisterFormPage.class);
        registerFormPage.registration(user.getName(), user.getEmail(), user.getPassword());
        LoginFormPage loginFormPage = page(LoginFormPage.class);

        assertTrue(loginFormPage.checkLogInAccountButton());
    }

    @DisplayName("Неуспешная регистрация с паролем менее 6 символов")
    @Test
    public void NonRegistrationPasswordIncorrect() {
        UserData user = UserData.getRandom(3);
        RegisterFormPage registerFormPage =  open(RegisterFormPage.URL, RegisterFormPage.class);
        registerFormPage.registration(user.getName(), user.getEmail(), user.getPassword());

        String actualText = registerFormPage.getTextPasswordIncorrect();
        String expectedText = "Некорректный пароль";
        assertEquals ("Текст не совпадает",expectedText, actualText);
    }
}
