package com.moa.model;

public class TestSuite {
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
	

	//Constructor to Capture testSuiteStep to setValue
	public TestSuite(TestSuiteStep testSuiteStep) {
		 testSuiteID = testSuiteStep.testSuiteID;
		 testSuiteName = testSuiteStep.testSuiteName;
		 testSuiteAnnotation = testSuiteStep.testSuiteAnnotation;
		 testScriptPath = testSuiteStep.testScriptPath;
		 testCaseSheetName = testSuiteStep.testCaseSheetName;
		 description = testSuiteStep.description;
		 dataProvider = testSuiteStep.dataProvider;
		 alwaysRun = testSuiteStep.alwaysRun;
		 groups = testSuiteStep.groups;
		 dependsOnGroup = testSuiteStep.dependsOnGroup;
		 priority = testSuiteStep.priority;
		 timeOut = testSuiteStep.timeOut;
		 ExpectedExceptions = testSuiteStep.ExpectedExceptions;
		 enable = testSuiteStep.enable;
	}
}