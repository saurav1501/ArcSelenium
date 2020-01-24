package com.arc.utility.group;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.arc.utility.BaseClass;

public class Test1 extends BaseClass{

	@Test(groups="Sanity")
	public void one() {
		
		System.out.println("one");
		driver.findElement(By.xpath(""));
		driver.getWindowHandle();
		driver.getCurrentUrl();
		driver.switchTo().alert();
		
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to("");
	
		
	}
}
