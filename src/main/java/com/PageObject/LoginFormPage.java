package com.PageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;

public class LoginFormPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";
    //Поле «Email»
    @FindBy(how = How.XPATH,using = ".//input[@name = 'name']")
    private SelenideElement emailField;
    //Поле «Пароль»
    @FindBy(how = How.XPATH,using = ".//input[@name = 'Пароль']")
    private SelenideElement passwordField;
    //поле «Email» активное
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement emailActField;
    //Кнопка «Войти»
    @FindBy(how = How.XPATH,using = ".//button[(text() = 'Войти')]")
    private SelenideElement logInAccountButton;
    //Кнопка «Зарегестрироваться»
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Зарегистрироваться')]")
    private SelenideElement registerButton;
    //Кнопка «Восстановить пароль»
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Восстановить пароль')]")
    private SelenideElement passwordRecoveryButton;
    //локатор кнопки «Оформить заказ»
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement placeOrderButton;

    @Step
    public void login (String email, String password)  {
        emailField.shouldBe(Condition.exist).click();
        emailActField.shouldBe(Condition.exist).click();
        emailActField.setValue(email);
        passwordField.click();
        passwordField.setValue(password);
        logInAccountButton.shouldBe(Condition.exist).click();
        placeOrderButton.shouldBe(visible);
    }
    //кнопка Войти видна
    @Step
    public boolean checkLogInAccountButton() {
        if (logInAccountButton.isDisplayed());
        return true;
    }
   }
