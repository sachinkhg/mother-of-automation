package com.moa.model;

public class TestSuite {
	public String testSuiteID;
	public String testSuiteName;
	public String testSuiteAnnotation;
	public String testScriptPath;
	public String testCaseSheetName;
	public String description;
	public String toRun;

	//Constructor to Capture String to setValue
	public TestSuite(String[][] eachStep) {
		testSuiteID = eachStep[0][0];
		testSuiteName = eachStep[0][1];
		testSuiteAnnotation = eachStep[0][2];
		testScriptPath = eachStep[0][3];
		testCaseSheetName = eachStep[0][4];
		description = eachStep[0][5];
		toRun = eachStep[0][6];
	}
	
}