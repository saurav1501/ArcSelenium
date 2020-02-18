package com.arc.ReusableMethods;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.arc.utility.BaseClass;
import com.arc.utility.CommonMethod; 


public class ReusableMethodsAddNewProject extends BaseClass{
	
	SimpleDateFormat formatarDate = new SimpleDateFormat(" HH:mm:ss");
	
	public void AddNewProject(String sheetName,int rowNum) throws Exception{
	/**************Reading data form excel sheet*************************/
	String prjName      = data.getCellData(sheetName,"ProjectName", rowNum);
	String prjType 		= data.getCellData(sheetName, "ProjectType", rowNum);
	String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
	String spaceType    = data.getCellData(sheetName, "SpaceType", rowNum);
	String ownerOrg 	= data.getCellData(sheetName, "OwnerOrganization", rowNum);
	String ownerType 	= data.getCellData(sheetName, "OwnerType", rowNum);
	String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum);
	String ownerMail 	= data.getCellData(sheetName, "OwnerEmail", rowNum);
	String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
	String prjCity 		= data.getCellData(sheetName, "City", rowNum);
	String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
	String prjState 	= data.getCellData(sheetName, "State", rowNum);
	String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
	Date date = new Date(System.currentTimeMillis());

	if(sheetName.equalsIgnoreCase("USBuildingProject")){
		prjName="USBuilding";
	}		
	CommonMethod.testlog("Pass", "Registering the Project");
	CommonMethod.visibilityOf("AddButton",avgWait);
	CommonMethod.click("AddButton");
	CommonMethod.visibilityOf("ProjectName",avgWait);
	
	String ProjectName = prjName+formatarDate.format(date);
	data.setCellData(sheetName,"ProjectName", rowNum, ProjectName);
	CommonMethod.sendKeys("ProjectName", ProjectName);
	CommonMethod.selectdropdown("ProjectType", prjType);
	CommonMethod.sendKeys("Area", prjArea);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CommonMethod.stringLocator("NoCertification"))));
	CommonMethod.click("NoCertification");
	CommonMethod.selectdropdown("UnitType","square feet");
	CommonMethod.selectdropdown("SpaceType", spaceType);
	CommonMethod.selectdropdown("OwnerType", ownerType);
	CommonMethod.click("organization");
	CommonMethod.sendKeys("organization", ownerOrg);
	Thread.sleep(1000);
	
	List<WebElement> elements = CommonMethod.findElements(("OwnerOrgSearch"));
	for(WebElement element : elements)
	{
		if(element.getText().contains(ownerOrg));
		element.click();
		break;
				
	}
	
	/*wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("OrgClick")));
	CommonMethod.click("OrgClick");
*/	CommonMethod.sendKeys("OwnerEmail", ownerMail);
	CommonMethod.selectdropdown("OwnerCountry", ownerCountry);
	CommonMethod.sendKeys("Address", prjAddress);
	CommonMethod.sendKeys("ProjCity", prjCity);
	CommonMethod.selectdropdown("Country", prjCountry);
	CommonMethod.selectdropdown("State",prjState);
	CommonMethod.sendKeys("ZipCode", prjZip);
	
	/*EventFiringWebDriver eventFiringDriver = new EventFiringWebDriver(driver);
	eventFiringDriver.executeScript("doccument.querySelector('').scrollTop=500");
	*/	
	
	
	}

    public ReusableMethodsNavigation gotoMeter() throws IOException {
    	CommonMethod.scrollDown();
    	CommonMethod.click("CheckBox");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("AddProject")));
    	CommonMethod.moveToElementAndClick("AddProject");
    	CommonMethod.switchToIframe("iframe");
    	CommonMethod.visibilityOf("NotificatinText", maxWait);
		return gotoMeter();
		
    }
    
   
   
}
