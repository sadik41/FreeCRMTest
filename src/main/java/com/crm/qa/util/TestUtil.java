package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 40;
    public static long IMPLICIT_WAIT = 25;

    public static String TESTDATA_SHEET_PATH = "E:\\AutomationVideoSelenium\\Architecture of Page Object Model (POM) Design With Selenium Naveen" +
            "\\OOPConceptionPOM\\" + "src\\main\\java\\com\\crm\\qa\\testdata\\FREE_CRM_Test_Data.xlsx";

    static Workbook book;
    static Sheet sheet;

    public void switchToFrame(){
        driver.switchTo().frame("rufous-sandbox");
    }

    public static Object[][] getTestData(String sheetName){
        FileInputStream file =null;

        try{
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (Exception e){
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//        System.out.println(sheet.getLastRowNum() + "------" +
//        sheet.getRow(0).getLastCellNum());
        for (int row=0;row<sheet.getLastRowNum();row++){
            for (int col = 0;col<sheet.getRow(0).getLastCellNum();col++){
                data[row][col] = sheet.getRow(row + 1).getCell(col).toString();
//                System.out.println(data[row][col]);
            }
        }
        return data;
    }

    public static void takeScreenShotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");

        FileUtils.copyFile(scrFile, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));

    }
}
