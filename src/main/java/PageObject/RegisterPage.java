package org.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BaseMethods{

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    //URLs
    public static final String REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";

    //xpaths
    private By inputName = By.xpath(".//label[contains(text(),'Имя')]/following-sibling::input");
    private By inputEmail = By.xpath(".//label[contains(text(),'Email')]/following-sibling::input");
    private By inputPassword = By.xpath(".//label[contains(text(),'Пароль')]/following-sibling::input");
    private By registerButton = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");

    // Методы

    public void fillInNameField(String generatedData){
        insertData(inputName,generatedData);
    }

    public void fillInEmailField(String generatedData){
        insertData(inputEmail,generatedData);
    }

    public void fillInPasswordField(String generatedData){
        insertData(inputPassword,generatedData);
    }

    public void clickRegisterButton(){
        findAndClick(registerButton);
    }

}
