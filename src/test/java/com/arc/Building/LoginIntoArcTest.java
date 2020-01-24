package com.arc.Building;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.utility.BaseClass;

public class LoginIntoArcTest extends BaseClass{
	
	  @Test(groups="Sanity", description="Verify if user is able to login with Valid UserName and password")
	  @Parameters({"rowNum","loginSheet"})
	  public void LoginIntoArc(int rowNum,String loginSheet) {
		  
		try { 
			login.LoginToArc(rowNum,"Projects", loginSheet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}