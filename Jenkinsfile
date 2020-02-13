env.agentName = ""
Properties prop

pipeline {
agent any 	 
stages {
        stage('Checkout Developer Code') {
           steps {
		   
           script {			    
			
            if ("${env.GIT_BRANCH}" == "master") {
                    env.agentName = "stg"
		    } else if("${env.GIT_BRANCH}" == "stg"){
                   env.agentName = "stg"
		    } else {
                        env.agentName = "false"
                   }
		    checkout([$class: 'GitSCM', branches: [[name: env.agentName]],doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/saurav1501/ArcSelenium.git']]])
                        prop = new Properties();
			FileInputStream config = new FileInputStream("${env.WORKSPACE}/Env/Config.properties");
		        prop.load(config);
		        prop.setProperty("environment", env.agentName);
		        echo prop.getProperty("environment")
                }
		  		
            }
}

    stage('Checkout Testing Code') {
           steps {     
           wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: false, shutdownWithBuild: true ,displayNameOffset: 1,installationName: 'Xvfb', parallelBuild: true, screen: '1600x1280x24', timeout: 60])
           {
                sh ' mvn -f pom.xml clean install'
		
            }
        }
    }

stage('Publish Html Report') {
            steps {
                echo 'Extend Report' 
		
        
        }
      

post {
always {
          publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'Reports', reportFiles: 'ARC_UITestingReport_Building.html', reportName: 'HTMLReport', reportTitles: ''])
	  publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'Reports', reportFiles: 'custom-emailable-report.html', reportName: 'HTMLReport', reportTitles: ''])
	   
	}
	
     failure {
     
      hipchatSend (color: 'RED', notify: true,
        message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
        )

	 emailext (to: 'ssinha@usgbc.org', subject: "FAILED: Job: '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
         body : readFile("Reports/custom-emailable-report.html"),   
         mimeType: 'text/html',recipientProviders: [[$class: 'DevelopersRecipientProvider']]);    
	    
	    
    }
    success {
      hipchatSend (color: 'GREEN', notify: true,
      message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
        )
   
         emailext (to: 'ssinha@usgbc.org', subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
         body : readFile("Reports/custom-emailable-report.html"),   
         mimeType: 'text/html',recipientProviders: [[$class: 'DevelopersRecipientProvider']]);   
	    
    }

    
	 
  }

}   
}
}	
