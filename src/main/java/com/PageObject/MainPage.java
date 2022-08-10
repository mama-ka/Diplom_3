package com.PageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    //Кнопка «Войти в аккаунт»
    @FindBy(how = How.XPATH, using = ".//button[(text() = 'Войти в аккаунт')]")
    private SelenideElement logInAccountButton;
    //Кнопка «Личный кабинет»
    @FindBy(how = How.XPATH,using = ".//p[(text() = 'Личный Кабинет')]")
    private SelenideElement personalAccountButton;
    //Кнопка «Оформить заказ»
    @FindBy(how = How.XPATH, using = ".//button[(text() = 'Оформить заказ')]")
    private SelenideElement placeOrderButton;
    //Текст заголовка «Соберите бургер»
    @FindBy(how = How.XPATH, using = ".//h1[(text() = 'Соберите бургер')]")
    private SelenideElement textConstructor;

    //Получить текст заголовка конструктора
    @Step
    public String getTextConstructor() {
        return textConstructor.getText();
    }
    //Кнопка «Оформить заказ» видна
    @Step
    public boolean isVisibleOrderButton(){
        placeOrderButton.shouldBe(Condition.visible);
        return true;
    }
    //Клик по кнопке «Войти в аккаунт» и переход на страницу входа
    @Step
    public LoginFormPage clickLogInAccountButton() {
            logInAccountButton.shouldBe(Condition.exist).click();
            return page(LoginFormPage.class);
        }
    //Клик по кнопке «Личный кабинет» и переход на страницу входа
    @Step
        public LoginFormPage clickPersonalAccountButton() {
            personalAccountButton.click();
            return page(LoginFormPage.class);
        }
    //Клик по кнопке «Личный кабинет» и переход в аккаунт
    @Step
    public AccountPage clickPersonalAccountButtonAndEntrancePersonalAccount() {
        personalAccountButton.click();
        return page(AccountPage.class);
    }
    }


