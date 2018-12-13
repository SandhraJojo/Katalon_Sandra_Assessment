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
import org.openqa.selenium.Keys as Keys

not_run: WebUI.openBrowser('')

not_run: WebUI.navigateToUrl('https://www.phptravels.net/admin')

not_run: WebUI.setText(findTestObject('Supplier/input_email'), 'admin@phptravels.com')

not_run: WebUI.setText(findTestObject('Supplier/input_password'), 'demoadmin')

not_run: WebUI.click(findTestObject('Supplier/span_Login'))

WebUI.callTestCase(findTestCase('TourCreation'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(4)

WebUI.click(findTestObject('Supplier/a_Accounts'))

WebUI.click(findTestObject('Supplier/a_Suppliers'))

WebUI.click(findTestObject('Supplier/button_Add'))

def dataExcel = TestDataFactory.findTestData('DatafileforSupplierCreation/SupplierData')

int i = 1

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'fname']), dataExcel.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'lname']), dataExcel.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'email']), dataExcel.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'password']), dataExcel.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'mobile']), dataExcel.getValue(i++, 1))

WebUI.click(findTestObject('Admin/Dropbox_Country/Click_Country'))

WebUI.click(findTestObject('Admin/Dropbox_Country/Select_Country', [('CountryVariable') : dataExcel.getValue(i++, 1)]))

//WebUI.click(findTestObject('Admin/Dropbox_Country/Select_Country'))
WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'address1']), dataExcel.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicname') : 'address2']), dataExcel.getValue(i++, 1))

WebUI.setText(findTestObject('Supplier/SupplierName/Name'), 'SupplierName')

WebUI.click(findTestObject('Supplier/Clicks/AssignHotelClick'))

WebUI.click(findTestObject('Supplier/Clicks/AssignHotelSelect'))

WebUI.click(findTestObject('Supplier/Clicks/AssignCarClick'))

WebUI.click(findTestObject('Supplier/Clicks/AssignCarSelect'))

WebUI.click(findTestObject('Supplier/Clicks/AssignTourClick'))

WebUI.click(findTestObject('Supplier/Clicks/AssignTourSelect'))

def dbdataforpermission = findTestData('DatafileforAdminCreation/Permission')

for (def index : (1..dbdataforpermission.getRowNumbers())) {
    for (def indexc : (1..dbdataforpermission.getColumnNumbers())) {
        WebUI.scrollToElement(findTestObject('Admin/Permission/Permission', [('PermissionVariable') : dbdataforpermission.getValue(
                        indexc, index)]), 10)

        WebUI.click(findTestObject('Admin/Permission/Permission', [('PermissionVariable') : dbdataforpermission.getValue(
                        indexc, index)]))
    }
}

WebUI.click(findTestObject('Common/Submit'))

