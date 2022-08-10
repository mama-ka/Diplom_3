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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountTest {
    public UserOperations userOperations = new UserOperations();
    public Map<String, String> responseData = new HashMap<>();

    @Before
    public void setUp (){
        responseData = userOperations.register();
        Configuration.startMaximized = true;
        LoginFormPage loginFormPage = open(LoginFormPage.URL, LoginFormPage.class);
        loginFormPage.login(responseData.get("email"),responseData.get("password"));
    }

    @After
    public void tearDown (){
        userOperations.delete();
    }

    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет»")
    @Test
    public void TransferToPersonalAccount() {
        MainPage startPage = open(MainPage.URL, MainPage.class);
        AccountPage accountPage = startPage.clickPersonalAccountButtonAndEntrancePersonalAccount();

        String actualText = accountPage.getTextInAccount();
        String expectedText = "В этом разделе вы можете изменить свои персональные данные";
        assertEquals ("Текст не совпадает",expectedText, actualText);

        String actualNameValue = accountPage.getNameValue();
        String expectedName = responseData.get("name");
        assertEquals("Имя не совпадает",expectedName, actualNameValue);
    }

    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    @Test
    public void LogoButtonInPersonalAccountOpenConstructor() {
        MainPage startPage = open(MainPage.URL, MainPage.class);
        AccountPage accountPage = startPage.clickPersonalAccountButtonAndEntrancePersonalAccount();
        MainPage mainPage = accountPage.clickLogoButton();

        String actualText = mainPage.getTextConstructor();
        String expectedText = "Соберите бургер";
        assertEquals ("Текст не совпадает",expectedText, actualText);
    }

    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    @Test
    public void ConstructorButtonInPersonalAccountOpenConstructor() {
        MainPage startPage = open(MainPage.URL, MainPage.class);
        AccountPage accountPage = startPage.clickPersonalAccountButtonAndEntrancePersonalAccount();
        MainPage mainPage = accountPage.clickConstructorButton();

        String actualText = mainPage.getTextConstructor();
        String expectedText = "Соберите бургер";
        assertEquals ("Текст не совпадает",expectedText, actualText);
    }

    @DisplayName("Выход из личного кабинета")
    @Test
    public void ExitPersonalAccount() {
        MainPage startPage = open(MainPage.URL, MainPage.class);
        AccountPage accountPage = startPage.clickPersonalAccountButtonAndEntrancePersonalAccount();
        LoginFormPage loginFormPage = accountPage.clickExitAccountButton();

        boolean exit = loginFormPage.checkLogInAccountButton();
        assertTrue("Кнопки Войти нет",exit);
    }
}
