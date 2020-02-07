pipeline{
		agent any
		properties([parameters([choice(choices: ['stg', 'qas', 'dev'], description: 'select environment to build', name: 'environment')]) 
			    ])
	        stages 
		{
		stage('Building Project') 
		{
		steps{
		echo "Building the Code.........."
		git 'https://github.com/saurav1501/ArcSelenium.git',branch : "${params.branch}"
		echo "Building the Code............"

		shell "mvn clean install"
		}
		}
		
		stage('Excuting Code...') 
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
         publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'Reports', reportFiles: 'ARC_UITestingReport_Building.html', reportName: 'ExtendReport', reportTitles: ''])
	     emailext (to: 'ssinha@usgbc.org', subject: "Email Report subject: '${env.JOB_NAME} - BuildNumber # ${env.BUILD_NUMBER}' ", 
         body : readFile("src/test/java/com/arc/utility/custom-emailable-report.html"),   
         mimeType: 'text/html');
	}
   }
      
}
	
