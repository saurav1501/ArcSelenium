pipeline{
		agent any
		
		stages 
		{
		stage('Building Project') 
		{
		steps{
		echo "Building the Code............"
		shell "mvn clean install"
		}
		}
		
		stage('Excuting Code..') 
		 {
		steps{
		  wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: false, shutdownWithBuild: true ,displayNameOffset: 1,installationName: 'Xvfb', parallelBuild: true, screen: '1600x1280x24', timeout: 60])
		  {
		  sh "mvn -f pom.xml clean install"
	   	  }
		  }
		}
		
	stage('Publish Html Report') {
            steps {
                echo 'Extend Report'    
        
        }
      }
     }
	   
      post {
        always {
        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'Reports', reportFiles: 'ARC_UITestingReport_Building.html', reportName: 'ExtendReport', reportTitles: ''])     
    
	    emailext (to: 'ssinha@usgbc.org', subject: "Email Report subject: '${env.JOB_NAME} - BuildNumber # ${env.BUILD_NUMBER}' ", 
            body : readFile("Reports/custom-emailable-report.html"),
		      
            mimeType: 'text/html');
	}
      }
      
}
	
