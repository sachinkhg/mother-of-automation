package com.moa.script;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.moa.util.Initiate;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 * Unit test for simple App.
 */
public class TestExecutor extends Initiate
{
	static Logger log = Logger.getLogger(TestExecutor.class);

	@BeforeSuite
	public void SetUpSuite() {
		System.out.println("@BeforeSuite");
//		PropertyConfigurator.configure(log4jConfPath);
		log.debug("Hello this is a debug message");
	    log.info("Hello this is an info message");		
	}
	@BeforeGroups
	public void SetUpGroup() {
		
		System.out.println("@BeforeGroups");
	}
	@BeforeClass
	public void SetUpClass() {
		System.out.println("@BeforeClass");
		
	}
	@BeforeTest
	public void SetUpTest() {
		System.out.println("@BeforeTest");
	}
	@Test
	public void BeginTest() {
		System.out.println("@Test");
		
	}
	@AfterSuite
	public void TearDownSuite() {
		System.out.println("@AfterSuite");
		
	}
	@AfterGroups
	public void TearDownGroup() {
		System.out.println("@AfterGroups");
		
	}
	@AfterTest
	public void TearDownTest() {
		System.out.println("@AfterTest");
		
	}
	@AfterClass
	public void TearDownClass() {
		System.out.println("@AfterClass");
		
	}
}
