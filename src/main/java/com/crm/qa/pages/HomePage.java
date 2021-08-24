package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'Sadikur Rahman')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[@class='item' and @href='/home']")
    WebElement mouseActions;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    WebElement tasksLink;

    //Initializing the page objects:
    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName(){
        return userNameLabel.isDisplayed();
    }
    public ContactsPage clickOnContactLink(){
        Actions action =new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@class='item' and @href='/home']"))).build().perform();
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink(){
        Actions action =new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@class='item' and @href='/home']"))).build().perform();
        dealsLink.click();
        return new DealsPage();
    }

    public TaskPage clickOnTaskLink(){
        Actions action =new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@class='item' and @href='/home']"))).build().perform();
        tasksLink.click();
        return new TaskPage();
    }


}
