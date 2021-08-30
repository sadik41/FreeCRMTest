package com.crm.qa.testdata;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactPage;

    String sheetName = "contacts";

    public ContactsPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        contactPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        contactPage = homePage.clickOnContactLink();
    }

    @Test(priority = 1, enabled = false)
    public void verifyContactsPageLabel() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(contactPage.verifyContactLabel(),"contacts label is missing on the page");
    }

    @Test(priority = 2, enabled = false)
    public void selectContactsTest(){
        contactPage.selectContactsByName("Sadikur Rahman");
    }

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data [][] =TestUtil.getTestData(sheetName);
        return data;
    }
    @Test(priority = 3,dataProvider = "getCRMTestData",enabled = false)
    public void createValidateNewContact(String firstname,String lastname,String company) throws InterruptedException {
        contactPage.createNewContact(firstname, lastname, company);
    }

    @Test(priority = 4, dataProvider = "getCRMTestData")
    public void createValidateNewContact2(String firstname,String lastname, String company) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("first_name")).sendKeys(firstname);
        driver.findElement(By.name("last_name")).sendKeys(lastname);
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[2]/div[2]/div/div/input")).sendKeys(company);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")).click();
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
