pipeline{
		agent any
	
	parameters{
		choice(choices: ['master', 'stg', 'dev', 'qas'], description: 'Select a branch to build project', name: 'environment')
                choice(choices: ['firefox', 'chrome', 'ie'], description: 'Select browser to build project', name: 'browserName')
		}
	        
	
	triggers {
        githubPush()
      }
	         stages{
		        stage('Building Proje99k') 
			
			
			 
		{
		steps{
		echo "Building th"
			echo "Building th"
			
				
			
				
		git branch: 'stg', url: 'https://github.com/saurav1501/ArcSelenium.git'
		echo "Building the Code........."
			echo "Building the Code........."
              
		
                echo "Building the Code........."
		shell "mvn clean install"
		}
		}
		
		stage('Excuting Code...') 
		 {
		steps{
		  wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: false, shutdownWithBuild: true ,displayNameOffset: 1,installationName: 'Xvfb', parallelBuild: true, screen: '1600x1280x24', timeout: 60])
		  {
		  sh "mvn -f pom.xml clean install"
	   	  }
		  }
		}
		
	stage('Publish Html Report') {
            steps {
                echo 'Extend Report'    
        
        }
      }
     }
	   
     
}
	
