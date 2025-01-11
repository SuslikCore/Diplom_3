package org.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BaseMethods{

    public MainPage(WebDriver driver){
        this.driver = driver;
    }



    //xpaths
    private By loginButton = By.xpath(".//button[contains(text(),'Войти в аккаунт')]");
    private By personalAccountLink = By.xpath(".//a[contains (@href, 'account')]");



    //URLs
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";

    //Методы
    //Открыть гл страницу
    public MainPage openMainPage(){
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    //Кликнуть по кнопке
    public void clickLoginButton(){
        findAndClick(loginButton);
    }

    public void clickAccountLink (){
        findAndClick(personalAccountLink);
    }







    //клик по элементу списка
//    public void clickQuestionElement(String question){
//        String questionLocator = String.format(FAQ_QUESTION_PATTERN, question);
//        WebElement element = driver.findElement(By.xpath(questionLocator));
//        new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.elementToBeClickable(element));
//        element.click();
//        new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.attributeToBe(element, "aria-expanded", "true"));
//    }



}
