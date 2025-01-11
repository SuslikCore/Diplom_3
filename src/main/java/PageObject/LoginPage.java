package org.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseMethods{

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //xpaths
    private By registerLink = By.xpath(".//a[contains (@href, 'register') and contains(text(),'Зарегистрироваться')]");
    private By inputEmail = By.xpath(".//label[contains(text(),'Email')]/following-sibling::input");
    private By inputPassword = By.xpath(".//label[contains(text(),'Пароль')]/following-sibling::input");
    private By loginButton = By.xpath(".//button[contains(text(),'Войти')]");


    //URLs
    public static final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";

    //Методы
    public void clickRegisterButton(){
        findAndClick(registerLink);
    }

    public void fillInEmailField(String generatedData){
        insertData(inputEmail,generatedData);
    }

    public void fillInPasswordField(String generatedData){
        insertData(inputPassword,generatedData);
    }

    public void clickLoginButton(){
        findAndClick(loginButton);
    }


}
