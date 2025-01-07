package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
    public abstract AbstractPage open();
    public AbstractPage enterTextInField(String fieldName, String enteredText) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldName)));
        driver.findElement(By.id(fieldName)).clear();
        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
        return this;
    }
    public String getElementText(String elementId){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(elementId)));
        return driver.findElement(By.id(elementId)).getText();
    }
}
