package com.facebook.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    private By header = By.xpath("//*[@id=\"mount_0_0_ia\"]/div/div[1]/div/div[3]/div/div/div[1]/div[1]/div/div[1]/div/div/div[1]/div/div/div[1]/ul/li/div/a/div[1]/div[2]/div/div/div/div/span/span");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeader() {
        return getElement(header);
    }
    public String getHomePageTitle()
    {
        return getPageTitle();
    }
    public String getHomePageHeader(){
        return getPageHeader(header);
    }
}
