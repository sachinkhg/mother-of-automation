package com.moa.script;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import com.moa.model.ObjectRepo;
import com.moa.model.TestScript;
import com.moa.model.TestSuite;
import com.moa.util.Initiate;
import com.moa.util.TestUtil;
import com.moa.util.XMLUtil;

public class BaseTest extends Initiate{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestUtil testUtil = new TestUtil();
//		List<TestSuite> testSuiteStep = testUtil.GetTestSuite("template/Test_Script_Sample.xlsm", "TS_1");
//		List<TestScript> testScriptStep = testUtil.GetTestCase("template/Test_Script_Sample.xlsm", "TC_1");
//		List<ObjectRepo> ObjectRepoList = testUtil.GetObjectRepo("template/Test_Script_Sample.xlsm", "OBJECT_REPO_1");
//		
//		System.out.println(testSuiteStep.get(0));
//		System.out.println(ObjectRepoList.get(0).page);
//		System.out.println(ObjectRepoList.get(0).name);
//		System.out.println(ObjectRepoList.get(0).locatorType);
//		System.out.println(ObjectRepoList.get(0).locatorValue);		
		XMLUtil  xmlUtil = new XMLUtil();
		xmlUtil.CreateXMLFileExample("xmlfile.xml");
//		PropertyConfigurator.configure(log4jConfPath);
//		TestListenerAdapter tla = new TestListenerAdapter();
//		TestNG testng = new TestNG();
//		List<String> suites = Lists.newArrayList();
//		suites.add("testng.xml");//path to xml..
//		testng.setTestSuites(suites);
//		testng.run();
	}

}
