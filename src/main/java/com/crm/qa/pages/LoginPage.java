package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory -OR: Object repository
    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    @CacheLookup
    WebElement loginFirstButton;

    @FindBy(name ="email")
    WebElement username;

    @FindBy(name ="password")
    WebElement password;

    @FindBy(xpath ="//div[@class='ui fluid large blue submit button']")
    WebElement loginButton;

    @FindBy(xpath ="//span[@class='ui fluid large blue submit button']")
    WebElement signUpBtn;

    @FindBy(xpath ="//h1[contains(text(),'Free CRM')]")
    WebElement crmLogo;

    //Initializing the page objects:
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCRMImage(){
        return crmLogo.isDisplayed();
    }

    public HomePage login(String username, String password) throws InterruptedException {
        Thread.sleep(3000);
        this.loginFirstButton.click();
        Thread.sleep(2000);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();

        return new HomePage();
    }


}
