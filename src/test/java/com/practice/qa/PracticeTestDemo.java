package com.practice.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class PracticeTestDemo {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver","C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.spicejet.com/");

        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Hot Meals')]")).click();
    }
}
