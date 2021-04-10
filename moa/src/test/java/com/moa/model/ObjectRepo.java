package com.moa.model;

public class ObjectRepo {
	public String page;
	public String name;
	public String locatorType;
	public String locatorValue;

	//Constructor to Capture String to setValue
	public ObjectRepo(String[][] eachStep) {
		page = eachStep[0][0];
		name = eachStep[0][1];
		locatorType = eachStep[0][2];
		locatorValue = eachStep[0][3];
	}
	
}
