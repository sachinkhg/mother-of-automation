package com.moa.script;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import com.moa.model.TestSuite;
import com.moa.util.Initiate;
import com.moa.util.TestUtil;

public class BaseTest extends Initiate{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestUtil testUtil = new TestUtil();
		List<TestSuite> testSuiteStep = testUtil.GetTestSuite("template/Test_Script_Sample.xlsm", "TS_1");
		
		PropertyConfigurator.configure(log4jConfPath);
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("testng.xml");//path to xml..
		testng.setTestSuites(suites);
		testng.run();
	}

}
