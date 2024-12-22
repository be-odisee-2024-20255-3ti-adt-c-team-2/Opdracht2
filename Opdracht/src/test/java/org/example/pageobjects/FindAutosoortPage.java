package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindAutosoortPage extends AbstractPage{

    public FindAutosoortPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FindAutosoortPage open() {
        driver.navigate().to("http://localhost:5000");
        return new FindAutosoortPage(this.driver);
    }

    public FindAutosoortPage clickButton(){
        driver.findElement(By.id("search-autosoort")).click();
        return this;
    }

    public String getFeedbackFromSearch() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.tagName("h3")));
        return driver.findElement(By.tagName("h3")).getText();
    }

    public String seeInPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        String result = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return result;
    }
}
