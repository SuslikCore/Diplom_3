package org.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseMethods {

    protected WebDriver driver;

    // Найти и кликнуть
    public void findAndClick (By locator){
        WebElement element = driver.findElement(locator);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Найти, кликнуть и заполнить
    public void insertData (By locator, String data){
        WebElement element = driver.findElement(locator);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(data);
    }

    // просто найти
    public void findElement (By locator){
        WebElement element = driver.findElement(locator);
        element.isDisplayed();
    }

    //Прокрутка до элемента
    public void scrollToElement (By locator){
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Получить текст
    public String getText(By locator){
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    //Получить аттрибут из элемента
    public String getAttribute(By locator,String attribute){
        WebElement element = driver.findElement(locator);
        return element.getAttribute(attribute);
    }

    public void tokenExtraction(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String token = (String) jsExecutor.executeScript("return localStorage.getItem('accessToken');");
        System.out.println(token);
    }


}
