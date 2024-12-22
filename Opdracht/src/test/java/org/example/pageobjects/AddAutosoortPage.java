package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAutosoortPage extends AbstractPage{

    public AddAutosoortPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage open() {
        driver.navigate().to("http://localhost:5000");
        return new AddAutosoortPage(this.driver);
    }

    public AddAutosoortPage submitForm(){
        driver.findElement(By.id("add-autosoort")).click();
        return this;
    }

}
