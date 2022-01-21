package com.PageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RecoveryPasswordFormPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    //Кнопка «Войти» в форме восстановления пароля
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Войти')]")
    private SelenideElement loginInPasswordRecoveryFormButton;

    @Step
    public LoginFormPage clickLoginInPasswordRecoveryButton() {
        loginInPasswordRecoveryFormButton.shouldBe(Condition.exist).click();
        return page(LoginFormPage.class);
    }
}
