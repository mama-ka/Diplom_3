package com.PageObject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class AccountPage {
    //Кнопка «Выход» в личном кабинете
    @FindBy(how = How.XPATH,using = ".//button[(text() = 'Выход')]")
    private SelenideElement exitAccountButton;
    //Текст в личном кабинете
    @FindBy(how = How.XPATH,using = ".//p[(text() = 'В этом разделе вы можете изменить свои персональные данные')]")
    private SelenideElement textInAccount;
    //Кнопка «Конструктор» в личном кабинете (в шапке)
    @FindBy(how = How.XPATH,using = ".//p[(text() = 'Конструктор')]")
    private SelenideElement constructorButton;
    //Логотип в личном кабинете (в шапке)
    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoButton;
    //Поле имя
    @FindBy(how = How.XPATH,using = "//input[@name='Name']")
    private SelenideElement nameField;

    //Получить текст из поля Имя
    @Step
    public String getNameValue() {
        return nameField.getAttribute("value");
    }
    //Клик по кнопке «Конструктор» и переход на главную страницу
    @Step
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }
    //Клик по логотипу и переход на главную страницу
    @Step
    public MainPage clickLogoButton() {
        logoButton.click();
        return page(MainPage.class);
    }
    @Step
    //Клик по кнопке «Выход» в личном кабинете и переход на страницу входа
    public LoginFormPage clickExitAccountButton() {
        exitAccountButton.click();
        return page(LoginFormPage.class);
    }
    @Step
    //Получить текст со старины личного кабинета
    public String getTextInAccount() {
        return textInAccount.getText();
    }
}
