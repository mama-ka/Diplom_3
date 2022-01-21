package com.PageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RegisterFormPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";
    //Поле «Имя»
    @FindBy(how = How.XPATH,using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")
    private SelenideElement nameRegisterField;
    //Поле «Email»
    @FindBy(how = How.XPATH,using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[2]")
    private SelenideElement emailRegisterField;
    //Поле «Пароль»
    @FindBy(how = How.XPATH,using = ".//input[@name = 'Пароль']")
    private SelenideElement passwordRegisterField;
    // ошибка регистрации, некорректный пароль
    @FindBy(how = How.XPATH,using = ".//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPass;
    //Кнопка «Зарегестрироваться» в форме регистрации
    @FindBy(how = How.XPATH,using = ".//button[(text() = 'Зарегистрироваться')]")
    private SelenideElement registerButton;
    //Кнопка «Войти» в форме регистрации
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Войти')]")
    private SelenideElement loginButton;

    //метод получения текста ошибки «Некорректный пароль»
    @Step
    public String getTextPasswordIncorrect () {
        return incorrectPass.getText();
    }

    //регистрация рандомного пользователя
    @Step
    public void registration (String name, String email, String password) {
        nameRegisterField.shouldBe(Condition.visible);
        nameRegisterField.setValue(name);
        emailRegisterField.setValue(email);
        passwordRegisterField.setValue(password);
        registerButton.click();
    }
    //Клик по кнопке Войти в форме регистрации
    @Step
    public LoginFormPage clickLoginButtonInRegisterForm() {
        loginButton.click();
        return page(LoginFormPage.class);
    }
  }
