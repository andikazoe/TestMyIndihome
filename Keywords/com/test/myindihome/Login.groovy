package com.test.myindihome

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

import internal.GlobalVariable

import com.test.basepageobject.BasePageObject

public class Login extends BasePageObject {
	
	private TestObject btnMasukDaftar
	private TestObject btnMasuk
	private TestObject inputEmailPhone
	private TestObject btnMasukEmailPhone
	private TestObject inputPassword
	private TestObject btnLanjutPassword
	private TestObject selectCondition
	private TestObject selectAktivasiWA
	private TestObject selectAktivasiSMS
	private TestObject inputOTP1
	private TestObject inputOTP2
	private TestObject inputOTP3
	private TestObject inputOTP4
	private TestObject btnLewati
	private TestObject btnProfile
	private TestObject btnKeluar
	private TestObject btnYa
	private TestObject btnCobalagi
	
	@Keyword
	public void loginFlow(Input_Email_Phone,Input_Password) {
		btnMasukDaftar = createTestObjectByXpath("btnMasukDaftar", "/html/body/div[1]/div/nav/div[1]/div[2]/ul/li[4]/button")
		btnMasuk = createTestObjectByXpath("btnMasuk", "/html/body/div[3]/div/div/div/div[2]/div/div[1]/a")
		inputEmailPhone = createTestObjectByID("inputEmailPhone", "loginID")
		btnMasukEmailPhone = createTestObjectByDataTestId("btnMasukEmailPhone", "submit")
		inputPassword = createTestObjectByID("inputPassword", "password")
		btnLanjutPassword = createTestObjectByDataTestId("btnLanjutPassword", "submit")
		
		WebUI.openBrowser(GlobalVariable.LINK_WEB)
		WebUI.maximizeWindow()
		WebUI.click(btnMasukDaftar)
		WebUI.delay(1)
		WebUI.click(btnMasuk)
		WebUI.delay(1)
		WebUI.setText(inputEmailPhone, Input_Email_Phone)
		WebUI.delay(1)
		WebUI.click(btnMasukEmailPhone)
		WebUI.delay(1)
		WebUI.setText(inputPassword, Input_Password)
		WebUI.delay(1)
		WebUI.click(btnLanjutPassword)
	}
	
	@Keyword
	public void loginCondition(Negative_Case, Select_Activation, OTP1, OTP2, OTP3, OTP4, Message) {
		if(Negative_Case == 'Yes') {
			WebUI.comment('Negative Case')
			selectCondition = createTestObjectByXpath("selectCondition", "//*/text()[normalize-space(.)='${Message}']/parent::*")
			btnCobalagi = createTestObjectByXpath("btnCobalagi", "//*/text()[normalize-space(.)='COBA LAGI']/parent::*")
			if(WebUI.waitForElementVisible(btnCobalagi, 3)) {
				WebUI.delay(1)
				WebUI.click(btnCobalagi)
				WebUI.delay(5)
			} else if(WebUI.waitForElementVisible(selectCondition, 3)) {
				WebUI.comment(Message)
				WebUI.delay(5)
			} else {
				WebUI.comment('Tidak ada condition')
			}
		} else if(Negative_Case == 'No') {
			WebUI.comment('Positive Case')
			loginMetodeAktivasi(Select_Activation, OTP1, OTP2, OTP3, OTP4)
		} else {
			WebUI.comment('Tidak ada pilihan Negative Case')
		}
	}
	
	@Keyword
	public void loginMetodeAktivasi(Select_Activation, OTP1, OTP2, OTP3, OTP4) {
		selectAktivasiWA = createTestObjectByXpath("selectAktivasiWA", "//img[@alt='Icon WA']")
		selectAktivasiSMS = createTestObjectByXpath("selectAktivasiSMS", "//img[@alt='Icon SMS']")
		inputOTP1 = createTestObjectByID("inputOTP1", "otp1")
		inputOTP2 = createTestObjectByID("inputOTP1", "otp2")
		inputOTP3 = createTestObjectByID("inputOTP1", "otp3")
		inputOTP4 = createTestObjectByID("inputOTP1", "otp4")
		btnLewati = createTestObjectByXpath("btnLewati", "//*/text()[normalize-space(.)='Lewati']/parent::*")
		btnProfile = createTestObjectByXpath("btnProfile", "//div[@id='basic-navbar-nav']/ul/li[4]/a/div")
		btnKeluar = createTestObjectByXpath("btnkeluar", "//*/text()[normalize-space(.)='keluar']/parent::*")
		btnYa = createTestObjectByXpath("btnkeluar", "//*/text()[normalize-space(.)='Ya']/parent::*")
		
		if(Select_Activation == 'WhatsApp') {
			WebUI.click(selectAktivasiWA)
		} else if(Select_Activation == 'SMS') {
			WebUI.click(selectAktivasiSMS)
		} else {
			WebUI.comment('Tidak ada pilihan Select Activation')
		}
		WebUI.click(inputOTP1)
		WebUI.setText(inputOTP1, OTP1)
		WebUI.click(inputOTP2)
		WebUI.setText(inputOTP2, OTP2)
		WebUI.click(inputOTP3)
		WebUI.setText(inputOTP3, OTP3)
		WebUI.click(inputOTP4)
		WebUI.setText(inputOTP4, OTP4)
		if(WebUI.waitForElementVisible(btnLewati, 10)) {
			WebUI.click(btnLewati)
		} else {
			WebUI.comment('Skip klik button lewati')
		}
		WebUI.delay(5)
		WebUI.click(btnProfile)
		WebUI.scrollToElement(btnKeluar, 0)
		WebUI.click(btnKeluar)
		WebUI.click(btnYa)
	}
	
}
