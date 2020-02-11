pipeline {
  agent any 
    stages {
        
       stage('Dev Code Checkout') {
	when {
                beforeAgent true
                branch 'stg'
              }
      steps {
       checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/saurav1501/ArcSelenium.git']]])
       
          
      }
    }
    stage('Build And Test') {
            steps {
                echo 'maven clean'
                wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: false, displayNameOffset: 1, installationName: 'Xvfb', parallelBuild: true, screen: '1600x1280x24', timeout: 25]) {
                //ABC indicates the folder name where the pom.xml file resides
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'git@github.com:agupta89/LeedOnlineAppTest.git']]])
                sh ' mvn -f pom.xml clean install'
                }
            
            }
        }
     stage('Publish Results') {
            steps {
                echo 'Commencing Email'   
		     echo 'Commencing Email'    
        
            }
    }
    }
}
