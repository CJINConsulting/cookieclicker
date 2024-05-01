package lexisnexus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptAllCookies;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void clickLinkContainingText(String partialLinkText) {
        driver.findElement(By.partialLinkText(partialLinkText)).click();
    }

    public void acceptAllCookies(){

        if (acceptAllCookies.isDisplayed()) {
            acceptAllCookies.click();
        }

        wait.until(ExpectedConditions.invisibilityOf(acceptAllCookies));

    }

    public String getNewWindowHandle() {
        /***
         * Gets the newly opened tab Window handle.
         * This will return the first handle found.
         */

        String currentWindowHandle = driver.getWindowHandle();

        // Get all window handles as a Set
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Use stream to filter out the current handle and return the first remaining handle
        return allWindowHandles.stream()
                .filter(handle -> !handle.equals(currentWindowHandle))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No new window found"));
    }

}