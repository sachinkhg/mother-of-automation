package com.moa.model;

public class TestSuiteStep {
	public String testSuiteID;
	public String testSuiteName;
	public String testSuiteAnnotation;
	public String testScriptPath;
	public String testCaseSheetName;
	public String description;
	public String dataProvider;
	public String alwaysRun;
	public String groups;
	public String dependsOnGroup;
	public String priority;
	public String timeOut;
	public String ExpectedExceptions;
	public String enable;

	//Constructor to Capture String to setValue
	public TestSuiteStep(String[][] eachStep) {
		testSuiteID = eachStep[0][0];
		testSuiteName = eachStep[0][1];
		testSuiteAnnotation = eachStep[0][2];
		testScriptPath = eachStep[0][3];
		testCaseSheetName = eachStep[0][4];
		description = eachStep[0][5];
		dataProvider = eachStep[0][6];
		alwaysRun = eachStep[0][7];
		groups = eachStep[0][8];
		dependsOnGroup = eachStep[0][9];
		priority = eachStep[0][10];
		timeOut = eachStep[0][11];
		ExpectedExceptions = eachStep[0][12];
		enable = eachStep[0][13];
	}
}
