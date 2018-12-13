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

not_run: WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'katalonCommonKeyword.katalon_uten.login'('www.phptravels.net/admin', 'admin@phptravels.com', 'demoadmin')

WebUI.click(findTestObject('Admin/Page_Dashboard/a_Accounts'))

WebUI.click(findTestObject('Admin/Page_Dashboard/a_Admins'))

WebUI.click(findTestObject('Admin/Page_Admins Management/button_Add'))


/*def elementName=['fname', 'lname' , 'email' , 'password' , 'mobile' , 'address1' , 'address2' ]

def dbdata = findTestData('DatafileforAdminCreation/Details')

int i = 1

for(i=1;i < elementName.size();i++)
{
	WebUI.setText(findTestObject('Common/fieldData', [('dynamicname') : elementName[i-1]]), dbdata.getValue(i++, 1))
}*/
def dbdata = findTestData('DatafileforAdminCreation/Details')

int i = 1


WebUI.setText(findTestObject('Common/fieldData', [('dynamicname') : 'fname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('dynamicname') : 'lname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('dynamicname') : 'email']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('dynamicname') : 'password']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('dynamicname') : 'mobile']), dbdata.getValue(i++, 1))

WebUI.click(findTestObject('Admin/Dropbox_Country/Click_Country'))

WebUI.click(findTestObject('Admin/Dropbox_Country/Select_Country', [('CountryVariable') : dbdata.getValue(i++, 1)]))

WebUI.setText(findTestObject('Common/fieldData', [('dynamicname') : 'address1']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('dynamicname') : 'address2']), dbdata.getValue(i++, 1))

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

