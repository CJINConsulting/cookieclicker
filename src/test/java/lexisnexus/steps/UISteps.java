package lexisnexus.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lexisnexus.pages.CareersPage;
import lexisnexus.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class UISteps {

    private WebDriver driver = null;
    private Duration wait = Duration.ofSeconds(30);
    private HomePage homePage = null;
    private CareersPage careersPage = null;

    @Before
    public void before() {
        String projectPath = System.getProperty("user.dir");
        System.out.println("project Path: " + projectPath);

        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(wait);
        driver.manage().timeouts().pageLoadTimeout(wait);
        driver.manage().window().maximize();

        driver.navigate().to("https://risk.lexisnexis.co.uk/");
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }

    @Given("the user is on the lexisnexus homepage")
    public void navigateToHomePage() {
        homePage = new HomePage(driver);
        homePage.acceptAllCookies();
    }

    @When("the {} menu is selected")
    public void theUserOpensTheMenuAndSelectsAnItem(String menuItem) {
        homePage.clickLinkContainingText(menuItem);
    }

    @And("the {} menu option is selected")
    public void theCareersMenuOptionIsSelected(String menuOption) {
        homePage.selectMenuItem(menuOption);
    }

    @When("the browser is switched to the Careers tab")
    public void theBrowserIsSwitchedToTheCareersTab() {
        String careersTab = homePage.getNewWindowHandle();
        careersPage = new CareersPage(driver.switchTo().window(careersTab));
    }

    @And("the user selects Search all jobs")
    public void theUserSelectsSearchAllJobs() {
        careersPage.searchAllJobs();
    }

    @Then("a list of jobs is shown on the page")
    public void listOfJobsAppears() {
        assertThat("There is at least one job visible in the search window", careersPage.countSearchResults(), greaterThan(1));
    }

}