package com.arc.Building;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.utility.BaseClass;

public class AddNewProjectTest extends BaseClass{
	@Parameters({"AddProject","rowNum"})
	@Test(groups={"Sanity,Regression"},dependsOnGroups="Sanity",description="Verify if user is able to register the Project")
	public void AddNewProject(String AddProject,int rowNum) {
		
			try {
				addProject.AddNewProject(AddProject, rowNum);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}


