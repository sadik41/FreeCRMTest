package com.facebook.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    //page locators
    private By emailId = By.xpath("//input[@id='email']");
    private By password = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button[@name='login']");
    private By header = By.xpath("//img[@class='fb_logo _8ilh img']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailId() {
        return getElement(emailId);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginButton() {
        return getElement(loginButton);
    }
    public WebElement getHeader() {
        return getElement(header);
    }

    public String getLoginPageTitle()
    {
        return getPageTitle();
    }

    public String getLoginPageHeader(){
         return getPageHeader(header);
    }

    public HomePage doLogin(String username,String password){
        getEmailId().sendKeys(username);
        getPassword().sendKeys(password);
        getLoginButton().click();

        return getInstance(HomePage.class);
    }

    public void doLogin(){
        getEmailId().sendKeys("");
        getPassword().sendKeys("");
        getLoginButton().click();
    }

    //username: sadik@gamil.com
    public void doLogin(String userCred){

        if (userCred.contains("username")){
            getEmailId().sendKeys(userCred.split(":")[1].trim());
        } else if (userCred.contains("password")){
            getEmailId().sendKeys(userCred.split(":")[1].trim());
        }
        getLoginButton().click();
    }

}
