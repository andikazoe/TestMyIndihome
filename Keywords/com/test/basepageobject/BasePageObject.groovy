package com.test.basepageobject

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testobject.ConditionType
import internal.GlobalVariable

public class BasePageObject {
	
	public TestObject createTestObjectByXpath(String objName, String xpath) {
		TestObject testObj = new TestObject(objName)
		testObj.addProperty("xpath",  ConditionType.EQUALS, xpath)
		return testObj
	}

	public TestObject createTestObjectByID(String objName, String ID) {
		TestObject testObj = new TestObject(objName)
		testObj.addProperty("id",  ConditionType.EQUALS, ID)
		return testObj
	}

	public TestObject createTestObjectByName(String objName, String Name) {
		TestObject testObj = new TestObject(objName)
		testObj.addProperty("name",  ConditionType.EQUALS, Name)
		return testObj
	}

	public TestObject createTestObjectByType(String objName, String Name) {
		TestObject testObj = new TestObject(objName)
		testObj.addProperty("type",  ConditionType.EQUALS, Name)
		return testObj
	}

	public TestObject createTestObjectByDataTestId(String objName, String Name) {
		TestObject testObj = new TestObject(objName)
		testObj.addProperty("data-testid",  ConditionType.EQUALS, Name)
		return testObj
	}
	
}
