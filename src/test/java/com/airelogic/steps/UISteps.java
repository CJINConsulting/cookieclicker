package com.airelogic.steps;

import com.airelogic.pages.HomePage;
import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.airelogic.pages.GamePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UISteps {

    private WebDriver driver = null;
    private Duration wait = Duration.ofSeconds(30);
    private HomePage homePage = null;
    private GamePage gamePage = null;

    private Faker faker = new Faker();

    private String savedName = null;

    @Before
    public void before() {
        String projectPath = System.getProperty("user.dir");
        System.out.println("project Path: " + projectPath);

        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(wait);
        driver.manage().timeouts().pageLoadTimeout(wait);
        driver.manage().window().maximize();

        driver.navigate().to("https://colin-piper-2024-05-20.cookieclickertechtest.airelogic.com/");
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }

    @Given("I am on the cookie clicker homepage")
    public void userIsOnTheHomepage() {
        homePage = new HomePage(driver);
    }

    @Given("I choose the name {string}")
    public void iSetTheNameTo(String yourName) {
        homePage.yourName.sendKeys(yourName);
        savedName = yourName;
    }

    @Given("I set the name to {int} characters long")
    public void iSetTheNameTo(int nameLength) {
        savedName = faker.lorem()
                .fixedString(nameLength)
                .trim();
        homePage.yourName.sendKeys(savedName);
    }

    @Given("I choose a random name")
    public void iSetARandomNameTo() {
        savedName = faker.funnyName().name();
        homePage.yourName.sendKeys(savedName);
    }

    @And("I start a new game")
    public void iStartANewGame() {
        homePage.startButton.click();
        gameStarted();
    }

    private void gameStarted() {
        gamePage = new GamePage(driver);
    }

    @Then("the game shows a welcome message including the name {string}")
    public void theGameShowsTheWelcomeMessage(String playerName) {
        assertThat(gamePage.getWelcomeMessage(), containsString(playerName));
    }

    @Then("the game shows a welcome message including the player's name")
    public void theGameShowsThePlayersNameInTheWelcomeMessage() {
        assertThat(gamePage.getWelcomeMessage(), containsString(savedName));
    }

    @And("the game values are set to zero")
    public void theGameValuesAreSetToZero() {
        assertCookieCount(0);
        assertFactoryCount(0);
        assertMoneyTotal(0.0F);
    }

    @And("I click a cookie")
    public void iClickACookie() {
        gamePage.clickCookie.click();
    }

    @And("I click {int} cookies")
    public void iClickXCookies(int numberOfCookies) {
        for (int i = 1; i <= numberOfCookies; i++) {
            gamePage.isClickable(gamePage.clickCookie).click();
        }
    }

    @Then("my cookie count should be {int}")
    public void myCookieCountShouldBe(int cookieCount) {
        assertCookieCount(cookieCount);
    }

    private void assertCookieCount(int expectedCount) {
        assertThat(gamePage.getCookieCount(), equalTo(expectedCount));
    }

    private void assertFactoryCount(int expectedCount) {
        assertThat(gamePage.getFactoryCount(), equalTo(expectedCount));
    }

    private void assertMoneyTotal(Float expectedTotal) {
        assertThat(gamePage.getMoneyTotal(), equalTo(expectedTotal));
    }

    @And("my factory count should be {int}")
    public void myFactoryCountShouldBe(int factoryCount) {
        assertFactoryCount(factoryCount);
    }

    @And("my money total should be {float}")
    public void myMoneyTotalShouldBe(Float moneyTotal) {
        assertMoneyTotal(moneyTotal);
    }

    @And("I sell {} cookies")
    public void iSellCookies(String cookiesToSell) {
        gamePage.cookiesToSell.sendKeys(cookiesToSell);
        gamePage.sellCookies.click();
        gamePage.isClickable(gamePage.sellCookies);
    }

    @When("I buy {} factor(y)(ies)")
    public void iBuyFactories(String factoriesToBuy) {
        gamePage.factoriesToBuy.sendKeys(factoriesToBuy);
        gamePage.buyFactories.click();
        gamePage.isClickable(gamePage.buyFactories);
    }

    @And("the cookie count goes up {int} per second")
    public void theCookieCountGoesUpPerSecond(int cookieCountSpeed) {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        int cookieCount = gamePage.getCookieCount();
        for(int i = 0; i < 10 ; i++) {
            System.out.println("checking cookie count is: " + cookieCount);
            wait.until(ExpectedConditions.textToBePresentInElement(gamePage.cookieCounter, String.valueOf(cookieCount)));
            cookieCount += cookieCountSpeed;
        }
    }
}