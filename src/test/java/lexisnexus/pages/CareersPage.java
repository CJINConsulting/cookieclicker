package lexisnexus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersPage extends BasePage{

    By searchAllJobsLink = By.linkText("Search all jobs");

    @FindBy(className = "search-results-item")
    List<WebElement> searchResultsList;

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void searchAllJobs() {
        driver.findElement(searchAllJobsLink).click();
    }

    public int countSearchResults() {
        return searchResultsList.size();
    }
}