package com.arc.utility.group;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.arc.utility.BaseClass;

public class Test1 {

	@Test(groups="Sanity")
	public void one() {
		String GIT_BRANCH="j";
		String environment="";
		if(GIT_BRANCH == "master") {
            environment = "qas";
	    }else if(GIT_BRANCH == "stg1"){
            environment = "stg";
	    }else if(GIT_BRANCH == "dev1"){
             environment = "stg";
		
	    }
		System.out.println(environment);

}
}