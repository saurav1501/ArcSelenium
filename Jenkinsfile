pipeline {
    agent any
    stages {
	    
	stage('Example Build') { 
      
      when {
      expression {
      beforeAgent true
      return env.GIT_BRANCH == "origin/master"
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
