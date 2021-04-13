package com.moa.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Sheet;

import com.moa.model.ObjectRepo;
import com.moa.model.TestScript;
import com.moa.model.TestStep;
import com.moa.model.TestSuite;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TestUtil extends Initiate{
	ExcelUtil excelUtil = new ExcelUtil();
	SeleniumUtil seleniumUtil = new SeleniumUtil();
	XMLUtil xmlUtil = new XMLUtil();
	
	HashMap<String, String> testSuiteIDMap = new HashMap<String, String>();
//	public Element findElement(String searchKey){
//		String elementGroup[][] = new String[1][6];
//		int beginRow = 1;
//		int beginCol = 1;
//		int endRow;
//		int endCol = 6;	
//		try {
//			excelUtil.CaptureExcelFileToRead(locatorPath);
//			Sheet sheet = excelUtil.CaptureExcelSheetToRead(locatorSheetName);
//			endRow = Integer.parseInt(excelUtil.CaptureExcelCellValueToRead(sheet, 0, 2)) + 1;
//			for(int searchIndex = 0; searchIndex <= endRow - beginRow; searchIndex++) {
//				int tempRow = searchIndex + beginRow;
//				String tempElement = excelUtil.CaptureExcelCellValueToRead(sheet, searchIndex + beginRow, 2);
//				if(tempElement.equalsIgnoreCase(searchKey)) {
//					elementGroup = excelUtil.CaptureExcelRowValueToRead(sheet, tempRow, beginCol, endCol);
//				}
//			}
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		
//		return new Element(elementGroup);
//	}
	
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
//	public void runTestStep(TestStep testStep) {
//		Element primaryElement = this.findElement(testStep.primaryElement);
//		Element secondaryElement = this.findElement(testStep.secondaryElement);
//		seleniumUtil.runCommand(testStep.primaryAction, primaryElement.attributeFinder, primaryElement.attributeValue, testStep.valueToEnter, secondaryElement.attributeFinder, secondaryElement.attributeValue);
//	}
//	public void runTestScript() {
//		List<TestStep> testScript = this.getTestCase();
//		TestStep testStep;
//		for(int stepIndex = 0; stepIndex < testScript.size(); stepIndex++) {
//			testStep = testScript.get(stepIndex);
//			this.runTestStep(testStep);
//		}
//	}
//
	//Read Object Repo from Excel Sheet
	public List<ObjectRepo> GetObjectRepo(String Object_Repo_path, String Object_Repo_sheet) {
		String eachStep[][] = new String[1][4];
		List<ObjectRepo> objectRepoList = new ArrayList<ObjectRepo>();
		int beginRow = 2;
		int beginCol = 0;
		int endRow;
		int endCol = 3;			
		try {
		excelUtil.CaptureExcelFileToRead(Object_Repo_path);
		Sheet sheet = excelUtil.CaptureExcelSheetToRead(Object_Repo_sheet);
		endRow = Integer.parseInt(excelUtil.CaptureExcelCellValueToRead(sheet, 0, 1)) - 1;
		for(int stepIndex = 0; stepIndex <= endRow - beginRow; stepIndex++) {
			int tempRow = stepIndex + beginRow;
			eachStep = excelUtil.CaptureExcelRowValueToRead(sheet, tempRow, beginCol, endCol);
			objectRepoList.add(new ObjectRepo(eachStep));
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return objectRepoList;
	}
	
	//Read test Case from Excel Sheet
	public List<TestScript> GetTestCase(String test_case_path, String test_case_sheet) {
		String eachStep[][] = new String[1][4];
		List<TestScript> testScriptList = new ArrayList<TestScript>();
		int beginRow = 2;
		int beginCol = 0;
		int endRow;
		int endCol = 3;			
		try {
		excelUtil.CaptureExcelFileToRead(test_case_path);
		Sheet sheet = excelUtil.CaptureExcelSheetToRead(test_case_sheet);
		endRow = Integer.parseInt(excelUtil.CaptureExcelCellValueToRead(sheet, 0, 1)) - 1;
		for(int stepIndex = 0; stepIndex <= endRow - beginRow; stepIndex++) {
			int tempRow = stepIndex + beginRow;
			eachStep = excelUtil.CaptureExcelRowValueToRead(sheet, tempRow, beginCol, endCol);
			testScriptList.add(new TestScript(eachStep));
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return testScriptList;
	}
	//Read test suite from Excel Sheet
	public List<TestSuite> GetTestSuite(String test_suite_path, String test_suite_sheet) {
		String eachStep[][] = new String[1][5];
		List<TestSuite> testSuiteList = new ArrayList<TestSuite>();
		
		int beginRow = 2;
		int beginCol = 0;
		int endRow;
		int endCol = 4;		
		
		try {
			excelUtil.CaptureExcelFileToRead(test_suite_path);
			Sheet sheet = excelUtil.CaptureExcelSheetToRead(test_suite_sheet);
			endRow = Integer.parseInt(excelUtil.CaptureExcelCellValueToRead(sheet, 0, 1)) - 1;
			
			for(int stepIndex = 0; stepIndex <= endRow - beginRow; stepIndex++) {
				int tempRow = stepIndex + beginRow;
				eachStep = excelUtil.CaptureExcelRowValueToRead(sheet, tempRow, beginCol, endCol);
				String[][] step = AddTestSuiteIDtoEachStep(eachStep);
				testSuiteList.add(new TestSuite(step));
			}
		}catch(Exception ex) {
				ex.printStackTrace();
		}
		return testSuiteList;
	}
	
	private String[][] AddTestSuiteIDtoEachStep(String[][] eachStep) {
		eachStep[0][0] = eachStep[0][0].replaceAll(" ", "");
		String step[][] = new String[1][6];
		if(testSuiteIDMap.get(eachStep[0][0]) == null) {
			step[0][5] = UUID.randomUUID().toString();
			testSuiteIDMap.put(eachStep[0][0], step[0][5]);			
		}else {
			step[0][5] = testSuiteIDMap.get(eachStep[0][0]);
		}
		step[0][0] = eachStep[0][0];
		step[0][1] = eachStep[0][1];
		step[0][2] = eachStep[0][2];
		step[0][3] = eachStep[0][3];
		step[0][4] = eachStep[0][4];
		return step;
	}
	public void GenerateXMLTestSuite(List<TestSuite> test_suite_list, String xmlFilePath) {
		
		Element rootElement = null;
		Attr attr;
		Document document = xmlUtil.CreateDocument();
		rootElement = xmlUtil.CreateRootElement("TestSuite");
		for(TestSuite testSuite: test_suite_list) {
			
//			if(document.getElementById(testSuite.testSuiteID)==null) {
//				rootElement = xmlUtil.CreateRootElement(testSuite.testSuiteName);				
//				attr = xmlUtil.setElementAttribute(rootElement, "id", testSuite.testSuiteID);
//				rootElement.setIdAttributeNode(attr, true);
//				System.out.println(document.getElementById(testSuite.testSuiteID));
//			}
			Element childElement = xmlUtil.CreateChildElement(rootElement, testSuite.testSuiteAnnotation);
			attr = xmlUtil.setElementAttribute(childElement, "id", testSuite.testSuiteID);
			xmlUtil.CreateChildElement(childElement, "TestSuiteName", testSuite.testSuiteName);
			xmlUtil.CreateChildElement(childElement, "TestScriptPath", testSuite.testScriptPath);
			xmlUtil.CreateChildElement(childElement, "TestCaseSheetName", testSuite.testCaseSheetName);
			xmlUtil.CreateChildElement(childElement, "Description", testSuite.description);


		}
		xmlUtil.CreateXMLFile(xmlFilePath);
	}	
}

