package com.facebook.mytests;

import com.facebook.mypages.BasePage;
import com.facebook.mypages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    WebDriver driver;
    public Page page;

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUpTest(String browser) throws InterruptedException {
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equals("ff")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("no browser is defined in xml file...");
        }
        driver.get("https://www.facebook.com/");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page = new BasePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
