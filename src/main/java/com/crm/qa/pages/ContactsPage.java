package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
    WebElement contactsLabel;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
    WebElement createContactButton;

    @FindBy(name = "first_name")
    WebElement f_Name;

    @FindBy(name = "last_name")
    WebElement l_Name;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[2]/div[2]/div/div/input")
    WebElement companyName;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
    WebElement saveButton;

    //Initializing the page object
    public ContactsPage(){
        super();
    }

    public boolean verifyContactLabel() throws InterruptedException {
        return contactsLabel.isDisplayed();
    }

    public void selectContactsByName(String name){
        driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div[@class='ui fitted read-only checkbox']//input[@name='id']")).click();
    }

    public void createNewContact(String f_Name,String l_Name,String companyName) throws InterruptedException {
        Thread.sleep(5000);
        createContactButton.click();
        Thread.sleep(3000);
        this.f_Name.sendKeys(f_Name);
        Thread.sleep(1000);
        this.l_Name.sendKeys(l_Name);
        Thread.sleep(1000);
        this.companyName.sendKeys(companyName);
        Thread.sleep(1000);
//        Select select = new Select(driver.findElement(By.xpath("//div[@name='category' and @class='ui selection upward dropdown']")));
//        select.selectByVisibleText(title);
        saveButton.click();
    }
}
