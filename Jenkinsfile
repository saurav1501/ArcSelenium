pipeline{
	agent any
	
	parameters{
		choice(choices: ['master', 'stg', 'dev', 'qas'], description: 'Select a branch to build project', name: 'environment')
        choice(choices: ['firefox', 'chrome', 'ie'], description: 'Select browser to build project', name: 'browserName')
	 }
	 

stages{
		stage('Git checkout Developer') 
		{
		steps
		{
		timeout(time: 1, unit: 'MINUTES') {
                    retry(5) {
                
                 echo "checkout Developer Code.."
	          echo "checkout Developer Code.."
	          
	        
	        
	       
		git branch: 'master', url: 'https://github.com/saurav1501/ArcSelenium.git'
		
			   
	    shell "mvn clean install"
		}
		}
		}
		}
		stage('Checkout Testing Project') 
		{
		steps{
		
		
		git branch: 'master', url: 'git@github.com:agupta89/leedonlineapptest.git'
		shell "mvn clean install"
		}
		}
		
		stage('Test Case Started') 
		 {
		steps{
		  wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: false, shutdownWithBuild: true ,displayNameOffset: 1,installationName: 'Xvfb', parallelBuild: true, screen: '1600x1280x24', timeout: 60])
		  {
		  sh "mvn -f pom.xml clean install"
	   	  }
		  }
		}
}
}

