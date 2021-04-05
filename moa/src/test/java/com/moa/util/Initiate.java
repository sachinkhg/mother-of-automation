package com.moa.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * The beginning of life. Everything starts here.
 */

public class Initiate {
	public static WebDriver driver;
	public static WebElement commonElement;
	public static WebDriverWait waitDriver;
	
	public static Workbook workbook;
	public static FileInputStream fileInputStream;
	
	public static String driverPath = "D:\\eclipse\\javaProject\\AutmationUI\\lib/chromedriver.exe";
	public static String locatorPath = "C:\\Users\\sachin\\Downloads\\ElementInventory.xlsx";
	public static String locatorSheetName = "Elements";
	public static String testCasePath = "C:\\Users\\sachin\\Downloads\\TestScript.xlsx";
	public static String testCaseSheetName = "Script";
	
	public static String log4jConfPath = "log4j.properties";
	
}
