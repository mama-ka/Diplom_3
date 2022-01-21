package com.PageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConstructorSectionMainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    //Кнопка «Булки»
    @FindBy(how = How.XPATH,using = ".//span[(text() = 'Булки')]")
    private SelenideElement bunButton;
    //Кнопка «Соусы»
    @FindBy(how = How.XPATH,using = ".//span[(text() = 'Соусы')]")
    private SelenideElement saucesButton;
    //Кнопка «Начинки»
    @FindBy(how = How.XPATH,using = ".//span[(text() = 'Начинки')]")
    private SelenideElement fillingsButton;
    //Заголовок «Булки»
    @FindBy(how = How.XPATH,using = ".//h2[(text() = 'Булки')]")
    private SelenideElement textBun;
    //Заголовок «Соусы»
    @FindBy(how = How.XPATH,using = ".//h2[(text() = 'Соусы')]")
    private SelenideElement textSauces;
    //Заголовок «Начинки»
    @FindBy(how = How.XPATH,using = ".//h2[(text() = 'Начинки')]")
    private SelenideElement textFillings;

    //Клик по кнопке «Булки»
    @Step
    public void clickBunButton() {
        bunButton.shouldBe(Condition.exist).click();
    }
    //Клик по кнопке «Соусы»
    @Step
    public void clickSaucesButton() {
        saucesButton.shouldBe(Condition.exist).click();
    }
    //Клик по кнопке «Начинки»
    @Step
    public void clickFillingsButton() {
        fillingsButton.shouldBe(Condition.exist).click();
    }
    //Получить текст заголовка «Булки»
    @Step
    public String getTextBun() {
        return textBun.getText();
    }
    //Получить текст заголовка «Соусы»
    @Step
    public String getTextSauces() {
        return textSauces.getText();
    }
    //Получить текст заголовка «Соусы»
    @Step
    public String getTextFilling() {
        return textFillings.getText();
    }
}
