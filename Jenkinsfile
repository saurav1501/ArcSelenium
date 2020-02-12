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
		echo 'Hello World'
		    echo 'Hello World'
            }
        }
        stage('Example Deploy') {
            
            steps {
                echo 'Deploying'
		     echo 'Deploying'
		   
            }
        }
    }
}
