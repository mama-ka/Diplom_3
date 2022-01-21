package com.PageObject;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class ConstructorSectionYandexTest {

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        Configuration.startMaximized = true;
    }
    @After
    public void tearDown (){
        webdriver().driver().close();
    }

    @DisplayName("Переход на вкладку Соусы")
    @Test
    public void SaucesConstructor() {
        ConstructorSectionMainPage startPage = open(ConstructorSectionMainPage.URL, ConstructorSectionMainPage.class);
        startPage.clickSaucesButton();
        String actualText = startPage.getTextSauces();
        String expectedText = "Соусы";
        assertEquals ("Текст не совпадает",expectedText, actualText);
        }

    @DisplayName("Переход на вкладку Начинки")
    @Test
    public void FillingsConstructor() {
        ConstructorSectionMainPage startPage = open(ConstructorSectionMainPage.URL, ConstructorSectionMainPage.class);
        startPage.clickFillingsButton();
        String actualText = startPage.getTextFilling();
        String expectedText = "Начинки";
        assertEquals ("Текст не совпадает",expectedText, actualText);
    }

    @DisplayName("Переход на вкладку Булки")
    @Test
    public void BunConstructor() {
        ConstructorSectionMainPage startPage = open(ConstructorSectionMainPage.URL, ConstructorSectionMainPage.class);
        startPage.clickFillingsButton();
        startPage.clickBunButton();
        String actualText = startPage.getTextBun();
        String expectedText = "Булки";
        assertEquals ("Текст не совпадает",expectedText, actualText);
    }
}
