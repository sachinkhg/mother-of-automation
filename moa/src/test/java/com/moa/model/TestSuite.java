package com.moa.model;

public class TestSuite {

	public String testSuiteName;
	public String testSuiteAnnotation;
	public String testScriptPath;
	public String testCaseSheetName;
	public String description;

	//Constructor to Capture String to setValue
	public TestSuite(String[][] eachStep) {
		testSuiteName = eachStep[0][0];
		testSuiteAnnotation = eachStep[0][1];
		testScriptPath = eachStep[0][2];
		testCaseSheetName = eachStep[0][3];
		description = eachStep[0][4];
	}
}