import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.junit.Before as Before
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('AdminCreation'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'katalonCommonKeyword.katalon_uten.login'('www.phptravels.net/admin', 'sanjo@gmail.com', 'inapp123')

WebUI.click(findTestObject('Tour/TourCreationUptoAdd/Page_Dashboard/a_Tours'))

WebUI.click(findTestObject('Tour/TourCreationUptoAdd/Page_Dashboard/a_Tours_1'))

WebUI.click(findTestObject('Tour/TourCreationUptoAdd/Page_Tours Management/button_Add'))

def internaldata = findTestData('DatafileforTourCreation/TourDetails')

int i = 1

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'tourname']), internaldata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'maxadult']), internaldata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'adultprice']), internaldata.getValue(i++, 1))

WebUI.click(findTestObject('Tour/TourClicks/ChildClick'))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'maxchild']), internaldata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'childprice']), internaldata.getValue(i++, 1))

WebUI.scrollToElement(findTestObject('Tour/TourClicks/InfantClick'), 2)

WebUI.click(findTestObject('Tour/TourClicks/InfantClick'))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'maxinfant']), internaldata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'infantprice']), internaldata.getValue(i++, 1))

WebUI.click(findTestObject('Tour/TourDropDowns/StarClick'))

WebUI.delay(1)

WebUI.click(findTestObject('Tour/TourDropDowns/StarSelect', [('starvar') : internaldata.getValue(i++, 1)]))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'tourdays']), internaldata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'tournights']), internaldata.getValue(i++, 1))

WebUI.click(findTestObject('Tour/TourDropDowns/TourTypeClick'))

WebUI.click(findTestObject('Tour/TourDropDowns/TourTypeSelect', [('TourtypeVar') : internaldata.getValue(i++, 1)]))

WebUI.click(findTestObject('Tour/TourDropDowns/Locationclick'))

WebUI.setText(findTestObject('Tour/TourDropDowns/LocationInsert'), 'paris')

WebUI.click(findTestObject('Tour/TourDropDowns/LocationSelect'))

WebUI.click(findTestObject('Tour/InclusionsTab/InclusionClick'))

WebUI.click(findTestObject('Tour/InclusionsTab/SelectClick'))

WebUI.click(findTestObject('Tour/InclusionsTab/SelectClick'))

def tourpermission = findTestData('DatafileforTourCreation/Inclusions')

for (def index : (1..tourpermission.getRowNumbers())) {
    WebUI.click(findTestObject('Tour/InclusionsTab/facilities', [('facility') : tourpermission.getValue(1, index)]))
}

WebUI.click(findTestObject('Tour/ExclusionsTab/ExclusionsClick'))

WebUI.click(findTestObject('Tour/ExclusionsTab/SelectClick'))

WebUI.click(findTestObject('Tour/ExclusionsTab/SelectClick'))

def ExTourPermission = findTestData('DatafileforTourCreation/Exclusions')

for (def index : (1..ExTourPermission.getRowNumbers())) {
    WebUI.click(findTestObject('Tour/ExclusionsTab/ExclusionFacilities', [('ExFacility') : ExTourPermission.getValue(1, 
                    index)]))
}

WebUI.click(findTestObject('Tour/SubmitButton/SubmitClick'))

