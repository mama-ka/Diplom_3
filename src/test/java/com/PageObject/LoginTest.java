package com.PageObject;
import com.UserOperations;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    public UserOperations userOperations = new UserOperations();
    public Map<String, String> responseData = new HashMap<>();

    @Before
    public void setUp (){
        responseData = userOperations.register();
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown (){
        userOperations.delete();
    }

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Test
    public void LoginClickBuyButtonLoginInAccountOnMainPage() {
        MainPage startPage = open(MainPage.URL, MainPage.class);
        LoginFormPage loginFormPage = startPage.clickLogInAccountButton();
        loginFormPage.login(responseData.get("email"),responseData.get("password"));
        MainPage mainPage = page(MainPage.class);
        assertTrue(mainPage.isVisibleOrderButton());
    }

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Test
    public void LoginClickBuyButtonPersonalAccountOnMainPage() {
        MainPage startPage = open(MainPage.URL, MainPage.class);
        LoginFormPage loginFormPage = startPage.clickPersonalAccountButton();
        loginFormPage.login(responseData.get("email"),responseData.get("password"));
        MainPage mainPage = page(MainPage.class);
        assertTrue(mainPage.isVisibleOrderButton());
    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Test
    public void LoginClickBuyButtonInRegistrationForm() {
        RegisterFormPage registerFormPage =  open(RegisterFormPage.URL, RegisterFormPage.class);
        LoginFormPage loginFormPage = registerFormPage.clickLoginButtonInRegisterForm();
        loginFormPage.login(responseData.get("email"),responseData.get("password"));
        MainPage mainPage = page(MainPage.class);
        assertTrue(mainPage.isVisibleOrderButton());
    }

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Test
    public void LoginClickBuyButtonInPasswordRecoveryForm() {
        RecoveryPasswordFormPage recoveryPasswordFormPage = open(RecoveryPasswordFormPage.URL, RecoveryPasswordFormPage.class);
        LoginFormPage loginFormPage = recoveryPasswordFormPage.clickLoginInPasswordRecoveryButton();
        loginFormPage.login(responseData.get("email"),responseData.get("password"));
        MainPage mainPage = page(MainPage.class);
        assertTrue(mainPage.isVisibleOrderButton());
    }
}
