pipeline {
    agent any
    stages {
	    
	stage('Example Build') { 
	when {
        expression {
        return sh(script: "git rev-parse --abbrev-ref HEAD", returnStdout: true) == "master"
         }
	}
            steps {
                echo 'Hello World'
            }
        }
        stage('Example Deploy') {
            
            steps {
                echo 'Deploying'
            }
        }
    }
}
