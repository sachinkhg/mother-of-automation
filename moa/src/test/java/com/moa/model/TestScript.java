package com.moa.model;

public class TestScript {

	public String testStep;
	public String locator;
	public String testData;
	public String testStepDescription;
	
	//Constructor to Capture String to setValue
	public TestScript(String[][] eachStep) {
		testStep = eachStep[0][0];
		locator = eachStep[0][1];
		testData = eachStep[0][2];
		testStepDescription = eachStep[0][3];
	}
}
