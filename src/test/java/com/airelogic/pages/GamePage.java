package com.airelogic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GamePage extends BasePage{

    @FindBy(css = "a[href='Cookie Clicker!']")
    public WebElement homepageLink;
    @FindBy(id = "cookies")
    public WebElement cookieCounter;
    @FindBy(id = "factories")
    public WebElement factoryCounter;
    @FindBy(id = "money")
    public WebElement moneyTotal;
    @FindBy(id = "click")
    public WebElement clickCookie;
    @FindBy(id = "cookies-to-sell")
    public WebElement cookiesToSell;
    @FindBy(id = "sell-cookies")
    public WebElement sellCookies;
    @FindBy(id = "factories-to-buy")
    public WebElement factoriesToBuy;
    @FindBy(id = "buy-factories")
    public WebElement buyFactories;



    public GamePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage() {
        return driver.findElement(By.xpath("//h1/following-sibling::p[1]")).getText();
    }

    public int getCookieCount() {
        return Integer.parseInt(cookieCounter.getText());
    }

    public int getFactoryCount() {
        return Integer.parseInt(factoryCounter.getText());
    }

    public Float getMoneyTotal() {
        return Float.parseFloat(moneyTotal.getText());
    }


}