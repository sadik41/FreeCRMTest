package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.IOException;

public class WebEventListener extends TestBase implements WebDriverEventListener {

    public void beforeNavigateTo(String url, WebDriver driver){
        System.out.println("Before navigating to: '"+url+"'");
    }

    public void afterNavigateTo(String url, WebDriver driver){
        System.out.println("Navigated to: '"+url+"'");
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver){
        System.out.println("value of the:"+element.toString()+" before any changes mode");
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver){
        System.out.println("Element value changed to:"+element.toString());
    }

    public void beforeClickOn(WebElement element, WebDriver driver){
        System.out.println("Trying to click on: "+element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver){
        System.out.println("Clicked on: "+element.toString());
    }

    public void beforeNavigateBack(WebDriver driver){
        System.out.println("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver driver){
        System.out.println("Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver driver){
        System.out.println("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver driver){
        System.out.println("Navigated forward to next page");
    }

    public void onException(Throwable error,WebDriver driver) {
        System.out.println("Exception occurred: " + error);
        try{
            TestUtil.takeScreenShotAtEndOfTest();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver){
        System.out.println("Trying to find element By : "+by.toString());
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver){
        System.out.println("Found element By : "+by.toString());
    }

    public void beforeScript(String script, WebDriver driver){
    }

    public void afterScript(String script, WebDriver driver){
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void beforeAlertAccept(WebDriver driver){

    }

    public void afterAlertAccept(WebDriver driver){

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateRefresh(WebDriver driver){

    }

    public void afterNavigateRefresh(WebDriver driver){

    }

    public void beforeChangeValueOf(WebElement element,WebDriver driver,CharSequence[] keyToSend){

    }

    public void afterChangeValueOf(WebElement element,WebDriver driver,CharSequence[] keyToSend){

    }

}
