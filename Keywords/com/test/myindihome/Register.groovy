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

public class Register extends BasePageObject {
	
	private TestObject btnMasukDaftar
	private TestObject btnDaftar
	private TestObject inputFullname
	private TestObject inputPonsel
	private TestObject inputEmail
	private TestObject inputPassword
	private TestObject btnDaftarSekarang
	private TestObject selectAktivasi
	private TestObject inputOTP1
	private TestObject inputOTP2
	private TestObject inputOTP3
	private TestObject inputOTP4
	private TestObject selectTidakBerlangganan
	private TestObject btnLanjut
	private TestObject btnMulaiMenjelajai
	private TestObject btnOk
	private TestObject selectCondition
	
	@Keyword
	public void registerFlow(Input_Fullname, Input_Ponsel, Input_Email,Input_Password) {
		btnMasukDaftar = createTestObjectByXpath("btnMasukDaftar", "/html/body/div[1]/div/nav/div[1]/div[2]/ul/li[4]/button")
		btnDaftar = createTestObjectByXpath("btnDaftar", "/html/body/div[3]/div/div/div/div[2]/div/div[2]/a")
		inputFullname = createTestObjectByID("inputFullname", "fullName")
		inputPonsel = createTestObjectByID("inputPonsel", "mobileNumber")
		inputEmail = createTestObjectByID("inputEmail", "email")
		inputPassword = createTestObjectByID("inputPassword", "password")
		btnDaftarSekarang = createTestObjectByXpath("btnDaftarSekarang", "/html/body/div[1]/div/div[2]/div/section/form/div[5]/button/span")

		WebUI.openBrowser(GlobalVariable.LINK_WEB)
		WebUI.maximizeWindow()
		WebUI.click(btnMasukDaftar)
		WebUI.delay(1)
		WebUI.click(btnDaftar)
		WebUI.delay(1)
		WebUI.setText(inputFullname, Input_Fullname)
		WebUI.delay(1)
		WebUI.setText(inputPonsel, Input_Ponsel)
		WebUI.delay(1)
		WebUI.setText(inputEmail, Input_Email)
		WebUI.delay(1)
		WebUI.setText(inputPassword, Input_Password)
		WebUI.delay(1)
		WebUI.click(btnDaftarSekarang)
	}
	
	@Keyword
	public void registerCondition(Negative_Case, Select_Activation, OTP1, OTP2, OTP3, OTP4, Message) {
		if(Negative_Case == 'Yes') {
			WebUI.comment('Negative Case')
			selectCondition = createTestObjectByXpath("selectCondition", "//*/text()[normalize-space(.)='${Message}']/parent::*")
			if(WebUI.waitForElementVisible(selectCondition, 5)) {
				WebUI.comment(Message)
				WebUI.delay(5)
			} else {
				WebUI.comment('Tidak ada condition')
			}
		} else if(Negative_Case == 'No') {
			WebUI.comment('Positive Case')
			registerMetodeAktivasi(Select_Activation, OTP1, OTP2, OTP3, OTP4)
		} else {
			WebUI.comment('Tidak ada pilihan Negative Case')
		}
	}
	
	@Keyword
	public void registerMetodeAktivasi(Select_Activation, OTP1, OTP2, OTP3, OTP4) {
		selectAktivasi = createTestObjectByXpath("selectAktivasi", "//*/text()[normalize-space(.)='${Select_Activation}']/parent::*")
		inputOTP1 = createTestObjectByID("inputOTP1", "otp1")
		inputOTP2 = createTestObjectByID("inputOTP1", "otp2")
		inputOTP3 = createTestObjectByID("inputOTP1", "otp3")
		inputOTP4 = createTestObjectByID("inputOTP1", "otp4")
		selectTidakBerlangganan = createTestObjectByXpath("selectTidakBerlangganan", "//*[@id='headingTwo']")
		btnLanjut = createTestObjectByXpath("btnLanjut", "/html/body/div[1]/div/div[2]/div/section/form/div[2]/button")
		btnMulaiMenjelajai = createTestObjectByXpath("btnMulaiMenjelajai", "/html/body/div[1]/div/section/div/div/div/a")
		btnOk = createTestObjectByXpath("btnMulaiMenjelajai", "//*/text()[normalize-space(.)='ok']/parent::*")
		
		if(WebUI.waitForElementPresent(btnOk, 5)) { //Jika gagal register
			WebUI.click(btnOk)
		} else {
			WebUI.click(selectAktivasi)
			WebUI.click(inputOTP1)
			WebUI.setText(inputOTP1, OTP1)
			WebUI.click(inputOTP2)
			WebUI.setText(inputOTP2, OTP2)
			WebUI.click(inputOTP3)
			WebUI.setText(inputOTP3, OTP3)
			WebUI.click(inputOTP4)
			WebUI.setText(inputOTP4, OTP4)
			WebUI.click(selectTidakBerlangganan)
			WebUI.click(btnLanjut)
			WebUI.click(btnMulaiMenjelajai)
		}
	}
	
}
