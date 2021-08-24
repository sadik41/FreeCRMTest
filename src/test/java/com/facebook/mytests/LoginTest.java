package com.facebook.mytests;

import com.facebook.mypages.HomePage;
import com.facebook.mypages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(priority = 1,enabled = false)
    public void verifyLoginPageTitleTest(){
        String title = page.getInstance(LoginPage.class).getLoginPageTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Facebook – log in or sign up");
    }

    @Test(priority = 2,enabled = false)
    public void verifyLoginPageHeaderTest(){
        String header = page.getInstance(LoginPage.class).getLoginPageHeader();
        System.out.println(header);
        Assert.assertEquals(header,"Rahman Sadikur");
    }

    @Test(priority = 3,enabled = true)
    public void doLoginTest(){
        HomePage homePage = page.getInstance(LoginPage.class).doLogin("sadikurrahman41@gmail.com","41403785sadik");
        String headerHome = homePage.getHomePageHeader();
        System.out.println(headerHome);
        Assert.assertEquals(headerHome,"Rahman Sadikur");
    }
}
