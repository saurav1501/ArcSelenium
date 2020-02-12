pipeline {
    agent any
    stages {
	    
	stage('Example Build') { 
      
        when {
                beforeAgent true
                branch 'master'
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
