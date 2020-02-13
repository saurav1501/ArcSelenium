env.agentName = ""
Properties prop

pipeline {
agent any 	 
stages {
        stage('Checkout Developer Code') {
            steps {
                script {			    
			
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
           wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: false, shutdownWithBuild: true ,displayNameOffset: 1,installationName: 'Xvfb', parallelBuild: true, screen: '1600x1280x24', timeout: 60]){
           checkout([$class: 'GitSCM', branches: [[name: env.agentName]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/saurav1501/ArcSelenium.git']]])
               
		script {
			sh 'printenv'
			prop = new Properties();
			FileInputStream config = new FileInputStream("${env.WORKSPACE}/Env/Config.properties");
		        prop.load(config);
			prop['environment'] == env.agentName
			echo prop.getProperty("environment");
			
			
                }
            
            }
        }
    }
	 stage('Executing Testing Code') {
         steps {  
		 echo 'maven clean Install'
		 shell "mvn clean install"
		 sh ' mvn -f pom.xml clean install'
              }
            
          }
        
    }
    }
}