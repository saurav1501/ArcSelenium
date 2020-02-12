env.agentName = ""
pipeline {
agent any 	 
triggers {
    GenericTrigger(
     genericVariables: [
      [key: 'ref', value: '.ref']
     ],
     printContributedVariables: true,
     printPostContent: true,
     silentResponse: false,
     
    )
  }
stages {
        stage('Prep') {
		when {
                beforeAgent true
                branch env.agentName
              }
            steps {
                script {	
		    println "${env.GIT_BRANCH}" 
			println "${env.GIT_BRANCH}"
			echo 'Commencing Email'    
		     
                    if ("${env.GIT_BRANCH}" == "origin/master") {
                        env.agentName = "master"
		    } else if("${env.GIT_BRANCH}" == "origin/stg"){
                        env.agentName = "stg"
		    } else {
                        env.agentName = "false"
                    }
			checkout([$class: 'GitSCM', branches: [[name: env.agentName]],doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/saurav1501/ArcSelenium.git']]])
                 
                }
            }
        }
	

    stage('Build And Test') {
	   
	 
            steps {    
                echo 'maven clean'
                wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: false, displayNameOffset: 1, installationName: 'Xvfb', parallelBuild: true, screen: '1600x1280x24', timeout: 25]) {
                //ABC indicates the folder name where the pom.xml file resides
                checkout([$class: 'GitSCM', branches: [[name: env.agentName]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/saurav1501/ArcSelenium.git']]])
                sh ' mvn -f pom.xml clean install'
                }
            
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

