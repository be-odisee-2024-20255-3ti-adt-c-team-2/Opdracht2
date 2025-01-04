package org.example.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ListAutosoortPage extends AbstractPage {
    public ListAutosoortPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public ListAutosoortPage open() {
        driver.navigate().to("http://localhost:5000");
        return new ListAutosoortPage(this.driver);
    }
    public ListAutosoortPage clickButton(){
        driver.findElement(By.id("get-autosoorts")).click();
        return this;
    }
    public boolean isInResultText(String text2befound) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bekende_autosoorten ul.result")));
            String result = resultElement.getText();
            return result.contains(text2befound);
        } catch (TimeoutException e) {
            System.out.println("Timeout: Element not found or not visible.");
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Unable to locate the element.");
            return false;
        }
    }
}
