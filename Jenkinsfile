pipeline{
	agent any
	parameters{
		choice(choices: ['master', 'stg', 'dev', 'qas'], description: 'Select a branch to build project', name: 'environment')
                choice(choices: ['firefox', 'chrome', 'ie'], description: 'Select browser to build project', name: 'browserName')
		
	}
	        
	         stages{
		
		stage('Building Projek') 
		{
		steps{
	       echo 'Commencing Email' 
	        echo 'Commencing Email' 
			 echo 'Commencing Email' 
		git branch: "${params.environment}", url: 'https://github.com/saurav1501/ArcSelenium.git'
	
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
		sh 'bundle exec rake spec'
        
        }
      

post {
    success {
      slackSend (color: '#00FF00', message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
      hipchatSend (color: 'GREEN', notify: true,
      message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
        )
   
         emailext (to: 'ssinha@usgbc.org', subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
         body : readFile("Reports/custom-emailable-report.html"),   
         mimeType: 'text/html',recipientProviders: [[$class: 'DevelopersRecipientProvider']]);   
	    
    }

    failure {
      slackSend (color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
      hipchatSend (color: 'RED', notify: true,
        message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
        )

	 emailext (to: 'ssinha@usgbc.org', subject: "FAILED: Job: '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
         body : readFile("Reports/custom-emailable-report.html"),   
         mimeType: 'text/html',recipientProviders: [[$class: 'DevelopersRecipientProvider']]);    
	    
	    
    }
	 any {
          publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'Reports', reportFiles: 'ARC_UITestingReport_Building.html', reportName: 'HTMLReport', reportTitles: ''])
	  publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'Reports', reportFiles: 'custom-emailable-report.html', reportName: 'HTMLReport', reportTitles: ''])
	   
	}
  }

}   
}
}	
