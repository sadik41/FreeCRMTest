package com.crm.qa.testdata;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactPage;
    DealsPage dealsPage;
    TaskPage taskPage;

    public HomePageTest() {
        super();
    }
    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitle(){
        String title = homePage.verifyHomePageTitle();
        Assert.assertEquals(title,"Cogmento CRM","Home page title not match");
    }

    @Test(priority = 2)
    public void verifyUserNameTest(){
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

   @Test(priority = 3)
   public void verifyContactLinkTest(){
        contactPage = homePage.clickOnContactLink();
   }

   @Test(priority = 4)
   public void verifyDealsLinkTest(){
        dealsPage = homePage.clickOnDealsLink();
   }
   @Test(priority = 5)
   public void verifyTasksLinkTest(){
        taskPage = homePage.clickOnTaskLink();
        driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")).click();
   }

    @AfterMethod
    public void tearDown(){
       driver.quit();
    }


}
