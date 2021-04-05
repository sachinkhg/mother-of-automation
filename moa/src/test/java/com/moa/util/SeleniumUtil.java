package com.moa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * All the answers to do the magic with browser generate down
 * #jargons
 * 1. proActAttri - PrimaryActionAttribute
 * 2. priActAttriValue - PrimaryActionAttributeValue
 * 3. secActAttri - SecondaryActionAttribute
 * 4. secActAttriValue - SecondaryActionAttributeValue
 */
public class SeleniumUtil extends Initiate {
	//********************************************************************************//
	//

	public void runCommand(String command, String priActAttri, String priActAttriValue, String valueToEnter, String secActAttri, String secActAttriValue) {
		try {
			switch(command) {
			case "open": 
				driver.get(valueToEnter);
				break;
			case "back": 
				driver.navigate().back();
				break;
			case "click": 
				this.clickElement(priActAttri, priActAttriValue);
				break;
			case "input": 
				this.inputElement(priActAttri, priActAttriValue, valueToEnter);
				break;
			case "clear": 
				this.clearElement(priActAttri, priActAttriValue);
				break;
			case "hoverandclick":
				this.hoverAndClickElement(priActAttri, priActAttriValue, secActAttri, secActAttriValue);
				break;
			case "close":
				driver.close();
				break;
			case "quit":
				driver.quit();
				break;
			case "verifyTitle":
				//assertEquals(valueToEnter, driver.getCurrentUrl());
				if(valueToEnter.equals(driver.getCurrentUrl())) {
					
				}
				break;
			default:
				break;
			}
		}catch(Exception ex) {
			//To be updated
			ex.printStackTrace();
		}
	}
	// command to use - input
	public void runCommand(String command, String priActAttri, String priActAttriValue, String valueToEnter) {
		this.inputElement(priActAttri, priActAttriValue, valueToEnter);
		//this.runCommand(command, priActAttri, priActAttriValue, valueToEnter, null, null);
	}
	// command to use - click, clear
	public void runCommand(String command, String priActAttri, String priActAttriValue) {
		this.runCommand(command, priActAttri, priActAttriValue, null, null, null);
	}
	// command to use - open
	public void runCommand(String command, String valueToEnter) {
		this.runCommand(command, null, null, valueToEnter, null, null);
	}
	// command to use - quit, close
	public void runCommand(String command) {
		this.runCommand(command, null, null, null, null, null);
	}
	// command to use - hoverandclick
	public void runCommand(String command, String priActAttri, String priActAttriValue, String secActAttri, String secActAttriValue) {
		this.runCommand(command, priActAttri, priActAttriValue, null, secActAttri, secActAttriValue);
	}
	
	//********************************************************************************//
	//Click Element on a webpage
	public void clickElement(String attribute, String attributeValue) {
		
		try {
			commonElement = this.findElement(attribute, attributeValue);
			commonElement.click();
		}catch(Exception ex) {
			//To be updated
		}
	}
	//Input Element on a webpage
	public void inputElement(String attribute, String attributeValue, String value) {
		
		try {
			commonElement = this.findElement(attribute, attributeValue);
			commonElement.sendKeys(value);
		}catch(Exception ex) {
			//To be updated
		}
	}
	//Clear Element on a webpage
	public void clearElement(String attribute, String attributeValue) {
		
		try {
			commonElement = this.findElement(attribute, attributeValue);
			commonElement.clear();
		}catch(Exception ex) {
			//To be updated
		}
	}
	//Hover & Click an Element on a webpage - Need Testing
	public void hoverAndClickElement(String priActAttri, String priActAttriValue, String secActAttri, String secActAttriValue) {
		WebElement elementToHover;
		WebElement elementToClick;
		try {
			Actions actions = new Actions(driver);
			elementToHover = this.findElement(priActAttri, priActAttriValue);
			actions.moveToElement(elementToHover).build().perform();
			elementToClick = this.findElement(secActAttri, secActAttriValue);
			actions.click(elementToClick).build().perform();
		}catch(Exception ex) {
			//To be updated
		}
	}
	//Get text in Element on a webpage
	public String getElementText(String attribute, String attributeValue) {
		String value = null;
		try {
			commonElement = this.findElement(attribute, attributeValue);
			value = commonElement.getText();
		}catch(Exception ex) {
			//To be updated
		}
		return value;
	}
	//Get tag in Element on a webpage
	public String getElementTag(String attribute, String attributeValue) {
		String value = null;
		try {
			commonElement = this.findElement(attribute, attributeValue);
			value = commonElement.getTagName();
		}catch(Exception ex) {
			//To be updated
			ex.printStackTrace();
		}
		return value;
	}

	//********************************************************************************//
	//Find By - element on webpage based on the attribute and attribute value
	private WebElement findElement(String attribute, String attributeValue) {
		try {
			By by = this.findByElement(attribute, attributeValue);
			waitDriver = new WebDriverWait(driver, 30);
			waitDriver.until(ExpectedConditions.visibilityOfElementLocated(by));
			commonElement = driver.findElement(by);
		}catch(Exception ex) {
			//To be updated
			ex.printStackTrace();
		}
		return commonElement;
	}
	private By findByElement(String attribute, String attributeValue) {
		By by = null;
		try {
			
			waitDriver = new WebDriverWait(driver, 30);
			switch(attribute) {
			case "id":
				by = By.id(attributeValue);
				break;
			case "class":
				By.className(attributeValue);
				break;
			case "name":
				By.name(attributeValue);
				break;
			case "xpath":
				by = By.xpath(attributeValue);
				break;
			case "cssSelector":
				By.cssSelector(attributeValue);
				break;
			case "linkText":
				By.linkText(attributeValue);
				break;
			case "partialLinkText":
				By.partialLinkText(attributeValue);
				break;
			case "tagName":
				By.tagName(attributeValue);
				break;
			}
		}catch(Exception ex) {
			//To be updated
			ex.printStackTrace();
		}
		return by;
	}
	//********************************************************************************//
}
