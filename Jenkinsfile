pipeline {
  agent any 
	
triggers {
    GenericTrigger(
     genericVariables: [
      [key: 'ref', value: '$.ref']
     ],

     causeString: 'Triggered on $ref',

     token: 'abc123',

     printContributedVariables: true,
     printPostContent: true,

     silentResponse: false,

     regexpFilterText: '$ref',
     regexpFilterExpression: 'refs/heads/' + BRANCH_NAME
    
    )
  }
  stages {
    stage('Some step') {
      steps {
        sh "echo $ref"
      }
    }
   
       stage('Dev Code Checkout') {
      steps {
       echo 'Dev Code Checkout'
       checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/saurav1501/ArcSelenium.git']]])
       echo 'env'
       echo "${env.ref}"
          
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

