pipeline {
	agent any
	parameters{
		choice(choices: ['master', 'stg', 'dev', 'qas'], description: 'Select a branch to build project', name: 'environment')
        choice(choices: ['firefox', 'chrome', 'ie'], description: 'Select browser to build project', name: 'browserName')
	 }
    
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
		    echo 'Hello World'  echo 'Hello World'
		echo 'Hello World'
		    echo 'Hello World'
		    
		
            }
        }
        stage('Example Deploy') {
             when {
                beforeAgent true
                branch 'master'
              }
            steps {
                echo 'Deploying'
		     echo 'Deploying'
		      echo 'Hello World'
		    
		   
            }
        }
    }
}
