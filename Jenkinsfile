pipeline{
		agent any
		
		stages 
		{
		stage('Building Project') 
		{
		steps{
		echo "Building the Code.........."
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
        
	emailext body: '', subject: 'Test', to: 'ssinha@usgbc.org'
			subject: "Email Report '${env.JOB_NAME} - Build# ${env.BUILD_NUMBER} -${env.BUILD_STATUS}'", 
            to: 'ssinha@usgbc.org', body : readFile("target\surefire-reports\emailable-report.html"),
            mimeType: 'text/html'
	}
      }
      
}
	
