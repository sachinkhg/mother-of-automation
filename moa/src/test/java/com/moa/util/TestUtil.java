package com.moa.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;

import com.moa.model.Element;
import com.moa.model.TestStep;

public class TestUtil extends Initiate{
	ExcelUtil excelUtil = new ExcelUtil();
	SeleniumUtil seleniumUtil = new SeleniumUtil();
	
	public Element findElement(String searchKey){
		String elementGroup[][] = new String[1][6];
		int beginRow = 1;
		int beginCol = 1;
		int endRow;
		int endCol = 6;	
		try {
			excelUtil.CaptureExcelFileToRead(locatorPath);
			Sheet sheet = excelUtil.CaptureExcelSheetToRead(locatorSheetName);
			endRow = Integer.parseInt(excelUtil.CaptureExcelCellValueToRead(sheet, 0, 2)) + 1;
			for(int searchIndex = 0; searchIndex <= endRow - beginRow; searchIndex++) {
				int tempRow = searchIndex + beginRow;
				String tempElement = excelUtil.CaptureExcelCellValueToRead(sheet, searchIndex + beginRow, 2);
				if(tempElement.equalsIgnoreCase(searchKey)) {
					elementGroup = excelUtil.CaptureExcelRowValueToRead(sheet, tempRow, beginCol, endCol);
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return new Element(elementGroup);
	}
	
	public List<TestStep> getTestCase(){
		String eachStep[][] = new String[1][5];
		List<TestStep> testScript = new ArrayList<TestStep>();
		int beginRow = 2;
		int beginCol = 1;
		int endRow;
		int endCol = 5;	
		try {
			excelUtil.CaptureExcelFileToRead(testCasePath);
			Sheet sheet = excelUtil.CaptureExcelSheetToRead(testCaseSheetName);
			endRow = Integer.parseInt(excelUtil.CaptureExcelCellValueToRead(sheet, 0, 3)) + 1;
			for(int stepIndex = 0; stepIndex <= endRow - beginRow; stepIndex++) {
				int tempRow = stepIndex + beginRow;
				eachStep = excelUtil.CaptureExcelRowValueToRead(sheet, tempRow, beginCol, endCol);
				testScript.add(new TestStep(eachStep));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return testScript;
	}
	public void runTestStep(TestStep testStep) {
		Element primaryElement = this.findElement(testStep.primaryElement);
		Element secondaryElement = this.findElement(testStep.secondaryElement);
		seleniumUtil.runCommand(testStep.primaryAction, primaryElement.attributeFinder, primaryElement.attributeValue, testStep.valueToEnter, secondaryElement.attributeFinder, secondaryElement.attributeValue);
	}
	public void runTestScript() {
		List<TestStep> testScript = this.getTestCase();
		TestStep testStep;
		for(int stepIndex = 0; stepIndex < testScript.size(); stepIndex++) {
			testStep = testScript.get(stepIndex);
			this.runTestStep(testStep);
		}
	}
}
