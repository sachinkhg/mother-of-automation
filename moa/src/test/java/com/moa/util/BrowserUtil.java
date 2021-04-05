package com.moa.util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil extends Initiate{
	public void openBrowser(String browserToOpen) {
		try {
			switch(browserToOpen){
				case "chrome":
					System.setProperty("webdriver.chrome.driver", driverPath);
					driver = new ChromeDriver();
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				default: 
					break;
			}
			driver.manage().window().maximize();
		}catch(Exception ex) {
			//To be updated
		}
	}

	public void RobotType(String text){
		try {
			Robot robot = new Robot();
			//Cntl + C 
			StringSelection stringSelection = new StringSelection(text);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);
			
			//Cntl + V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(40);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void RobotType(int key){
		try {
			Robot robot = new Robot();
			robot.keyPress(key);
			robot.keyRelease(key);
			robot.delay(40);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
