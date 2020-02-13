env.agentName = ""
pipeline {
agent any 	 
stages {
        stage('Checkout Developer Code') {
            steps {
                script {	
		    println "${env.GIT_BRANCH}" 
			println "${env.GIT_BRANCH}"
			println "${env.GIT_BRANCH}"
			
			
                    if ("${env.GIT_BRANCH}" == "master") {
                        env.agentName = "master"
		    } else if("${env.GIT_BRANCH}" == "stg"){
                        env.agentName = "stg"
		    } else {
                        env.agentName = "false"
                    }
		    checkout([$class: 'GitSCM', branches: [[name: env.agentName]],doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/saurav1501/ArcSelenium.git']]])
                 
                }
            }
        }
	

    stage('Checkout Testing Code') {
            steps {    
              
                wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: false, displayNameOffset: 1, installationName: 'Xvfb', parallelBuild: true, screen: '1600x1280x24', timeout: 25]) {
                checkout([$class: 'GitSCM', branches: [[name: env.agentName]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/saurav1501/ArcSelenium.git']]])
               
		script {
			def props = readFile("Env/Config.properties")
			def environment = prop.getProperty("environment");
			
                }
            
            }
        }
    }
	 stage('Executing Testing Code') {
            steps {  
		 echo env.environment
		 echo env.environment
		 echo 'maven clean Install'
		 shell "mvn clean install"
		 sh ' mvn -f pom.xml clean install'
                }
            
            }
        
	
	
     stage('Publish Results') {
            steps {
                echo 'Commencing Email'   
		     echo 'Commencing Email' 
		    echo 'Commencing Email'
        
            }
    }
    }
}
