package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobjects.AddAutosoortPage;
import org.example.pageobjects.DeleteAutosoortPage;
import org.example.pageobjects.FindAutosoortPage;
import org.example.pageobjects.ListAutosoortPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStepDefsUI {
    WebDriver driver;
    AddAutosoortPage addAutosoortPage;
    DeleteAutosoortPage deleteAutosoortPage;
    ListAutosoortPage listAutosoortPage;
    FindAutosoortPage findAutosoortPage;
    @Before("@UI")
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");   // die infobars zijn vervelend
        options.addArguments("--remote-allow-origins=*"); // dit bleek nu nodig
        driver = new ChromeDriver(options);
        deleteAutosoortPage = new DeleteAutosoortPage(driver);
        deleteAutosoortPage.open();
        deleteAutosoortPage.clickButton();  // start van lege lijst
        addAutosoortPage = new AddAutosoortPage(driver);
        addAutosoortPage.open();
        insertAutosoort("Model X", "Tesla", "2", "1", "10");
        insertAutosoort("Model a8", "Audi", "1", "1", "5");
        insertAutosoort("Chin", "BYD", "2", "1", "3");
    }

    void insertAutosoort(String naam, String merk, String huidigVoorraadniveau, String minimumpeiler, String maximumpeiler) {
        this.addAutosoortPage.enterTextInField("naam" , naam);
        this.addAutosoortPage.enterTextInField("merk" , merk);
        this.addAutosoortPage.enterTextInField("huidigVoorraadniveau" , huidigVoorraadniveau);
        this.addAutosoortPage.enterTextInField("min" , minimumpeiler);
        this.addAutosoortPage.enterTextInField("max" , maximumpeiler);
        this.addAutosoortPage.submitForm();
    }

    @After("@UI")
    public void tearDown() {
        driver.close();
    }

    @Given("I am on the page where I can introduce a new autosoort")
    public void iAmOnThePageWhereICanIntroduceANewAutosoort() {
        this.addAutosoortPage = new AddAutosoortPage(driver);
        this.addAutosoortPage.open();
    }

    @When("I enter the necessary details for a autosoort")
    public void iEnterTheNecessaryDetailsForAAutosoort() {
        this.addAutosoortPage = new AddAutosoortPage(driver);
        this.addAutosoortPage.open();
        insertAutosoort("GLE", "Mercedes", "2", "1", "15");
    }

    @Then("I should be able to look up and find that autosoort")
    public void iShouldBeAbleToLookUpAndFindThatAutosoort() {
        this.findAutosoortPage = new FindAutosoortPage(driver);
        this.findAutosoortPage.open();
        this.findAutosoortPage.enterTextInField("naamToBeFound", "GLE");
        this.findAutosoortPage.clickButton();
        assertThat(findAutosoortPage.getFeedbackFromSearch()).contains("Gevonden: GLE Mercedes");
    }

    @And("the data of that autosoort should show up in the list")
    public void theDataOfThatAutosoortShouldShowUpInTheList() {
        this.listAutosoortPage = new ListAutosoortPage(driver);
        this.listAutosoortPage.open();
        this.listAutosoortPage.clickButton();
        assertThat(listAutosoortPage.isInResultText("id: 1 -- Model X Tesla -- Voorraad:2\n" +
                "minimum: 1 -- maximum: 10\n" +
                "id: 2 -- Model a8 Audi -- Voorraad:1\n" +
                "minimum: 1 -- maximum: 5\n" +
                "id: 3 -- Chin BYD -- Voorraad:2\n" +
                "minimum: 1 -- maximum: 3\n" +
                "id: 4 -- GLE Mercedes -- Voorraad:2\n" +
                "minimum: 1 -- maximum: 15")).isTrue();
    }


    @When("^I enter \"([^\"]+)\" in the ([^\"]*) field$")
    public void iEnterField(String enteredText, String fieldName) {
        this.addAutosoortPage.enterTextInField(fieldName, enteredText);
    }

    @And("I click the Add autosoort button")
    public void iClickTheAddAutosoortButton() {
        this.addAutosoortPage.submitForm();
    }

    @Then("I should see a message containing {string}")
    public void iShouldSeeAMessageContaining(String text2bFound) {
        String bodyText = this.addAutosoortPage.getElementText("resultaat_toevoeging");
        assertThat(bodyText).contains(text2bFound);
    }

    @And("{int} autosoorts were introduced")
    public void autosoortsWereIntroduced(int number) {
    }

    @And("I am on the page where I can delete autosoorts")
    public void iAmOnThePageWhereICanDeleteAutosoorts() {
        this.deleteAutosoortPage = new DeleteAutosoortPage(driver);
        this.deleteAutosoortPage.open();
    }

    @When("I click the Delete Autosoorts button")
    public void iClickTheDeleteAutosoortsButton() {
        this.deleteAutosoortPage.clickButton();
        // Nodig om te kijken of delete geslaagd is in volgende stap
        this.listAutosoortPage = new ListAutosoortPage(driver);
    }

    @And("I click on the List Autosoorts button")
    public void iClickOnTheListAutosoortsButton() {
        this.listAutosoortPage.clickButton();
    }

    @Then("I should see an empty list")
    public void iShouldSeeAnEmptyList() {
        String result = this.deleteAutosoortPage.getResultText();
        assertThat(result.length()).isEqualTo(0);
    }

    @And("I am on the page where I can find a autosoort")
    public void iAmOnThePageWhereICanFindAAutosoort() {
        this.findAutosoortPage = new FindAutosoortPage(driver);
    }

    @When("I enter {string} in the naamToBeFound field for searching")
    public void iEnterInTheNaamToBeFoundFieldForSearching(String naam) {
        this.findAutosoortPage.enterTextInField("naamToBeFound", naam);

    }

    @And("I click the Search Autosoort button")
    public void iClickTheSearchAutosoortButton() {
        this.findAutosoortPage.clickButton();
    }

    @Then("I should see a message {string}")
    public void iShouldSeeAMessage(String text2bFound) {
        assertThat(this.findAutosoortPage.getFeedbackFromSearch()).contains(text2bFound);
    }

    @Then("I should see an alert {string}")
    public void iShouldSeeAnAlert(String text) {
        assertThat(this.findAutosoortPage.seeInPopup()).contains("Server returned 404");
    }

    @Given("I am on the page where I can list the known autosoorts")
    public void iAmOnThePageWhereICanListTheKnownAutosoorts() {
        this.listAutosoortPage = new ListAutosoortPage(driver);
        this.listAutosoortPage.open();
    }

    @Then("I should see a text containing {string} and {string} and {string}")
    public void iShouldSeeATextContainingAndAnd(String string1, String string2, String string3) {
        assertThat(this.listAutosoortPage.isInResultText(string1)).isTrue();
        assertThat(this.listAutosoortPage.isInResultText(string2)).isTrue();
        assertThat(this.listAutosoortPage.isInResultText(string3)).isTrue();
    }
}
