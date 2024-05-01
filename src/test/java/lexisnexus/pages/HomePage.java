package lexisnexus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectMenuItem(String menuItemName) {
        driver.findElement(By.xpath("//h4[text()='" + menuItemName + "']/following-sibling::div/descendant::a[contains(@class, 'btn-clickable-area')]"))
                .click();
    }
}