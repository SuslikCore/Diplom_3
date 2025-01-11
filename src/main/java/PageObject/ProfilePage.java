package org.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BaseMethods{

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    //xpaths
    private By inputUserName = By.xpath(".//label[contains(text(),'Имя')]/following-sibling::input");
    private By inputEmail = By.xpath(".//label[contains(text(),'Логин')]/following-sibling::input");

    //URLs
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";

    //Методы
    public String getUserName(){
        return getAttribute(inputUserName,"Value");
    }

    public String getEmail(){
        return getAttribute(inputEmail,"Value");
    }




}
