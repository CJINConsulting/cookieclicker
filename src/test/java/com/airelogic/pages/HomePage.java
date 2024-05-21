package com.airelogic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "name")
    public WebElement yourName;
    @FindBy(xpath = "//button[text()='Start!']")
    public WebElement startButton;

    public String getPlayerScore(String playerName) {
        return driver.findElement(By.cssSelector("a[href='/game/'" + playerName + "]")).getText();
    }

    public WebElement getExistingGameLinkByName(String name) {
        return driver.findElement(By.linkText(name));
    }
}