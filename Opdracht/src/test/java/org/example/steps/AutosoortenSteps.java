package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class AutosoortenSteps {

    WebDriver driver;

    @Given("er zijn geen bekende autosoorten")
    public void geenBekendeAutosoorten() {
        driver = new ChromeDriver();
        driver.get("http://localhost:5000");

        WebElement deleteButton = driver.findElement(By.id("delete-all-autosoorten"));
        deleteButton.click();
    }

    @Given("er zijn 3 bekende autosoorten")
    public void drieBekendeAutosoorten() {
        driver = new ChromeDriver();
        driver.get("http://localhost:5000");

        WebElement addAutosoortButton = driver.findElement(By.id("add-autosoort"));
        addAutosoortButton.click();
    }

    @When("de Verkoper een lijst van bekende autosoorten opvraagt")
    public void verkoperOpvraagt() {
        WebElement fetchButton = driver.findElement(By.id("fetch-autosoorten"));
        fetchButton.click();
    }

    @Then("krijgt hij \"Aantal bekende autosoorten 0\" als resultaat")
    public void controleerAantalAutosoorten() {
        WebElement resultElement = driver.findElement(By.id("result"));
        String resultText = resultElement.getText();
        Assert.assertTrue(resultText.contains("Aantal bekende autosoorten 0"));
    }

    @Then("krijgt hij als resultaat voor de lijst van bekende autosoorten")
    public void controleerLijstVanAutosoorten() {
        WebElement resultElement = driver.findElement(By.id("result"));
        String resultText = resultElement.getText();

        Assert.assertTrue(resultText.contains("Fiesta Ford"));
        Assert.assertTrue(resultText.contains("Corolla Toyota"));
        Assert.assertTrue(resultText.contains("Model 3 Tesla"));
        Assert.assertTrue(resultText.contains("Aantal bekende autosoorten 3"));
    }
}
