env.agentName = ""
Properties prop

pipeline {
agent any 

stages {
        stage('Checkout Code..') {
		when {
                   anyOf { 
		   branch 'master'; branch 'stg' ; 
		   }
	           beforeAgent true
		   }
                   steps {
		   echo 'Hello World'
                   script {			    	
                   if ("${env.GIT_BRANCH}" == "master") {
                   env.agentName = "stg"
		    } else if("${env.GIT_BRANCH}" == "stg"){
                   env.agentName = "stg"
		    } else {
                        env.agentName = "false"
                   }
		    echo env.agentName
		    checkout([$class: 'GitSCM', branches: [[name: 'master']],doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/saurav1501/ArcSelenium.git']]])
                    
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

        }   
}
}
