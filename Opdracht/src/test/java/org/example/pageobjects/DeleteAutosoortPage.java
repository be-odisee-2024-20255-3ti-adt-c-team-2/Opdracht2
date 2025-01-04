package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteAutosoortPage extends AbstractPage{
    public DeleteAutosoortPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public DeleteAutosoortPage open() {
        driver.navigate().to("http://localhost:5000");
        return new DeleteAutosoortPage(this.driver);
    }
    public DeleteAutosoortPage clickButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("delete-autosoorts")));
        driver.findElement(By.id("delete-autosoorts")).click();
        return this;
    }
    public String getResultText(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#bekende_autosoorten ul.result")));
        return driver.findElement(By.cssSelector("#bekende_autosoorten ul.result")).getText();
    }
}
