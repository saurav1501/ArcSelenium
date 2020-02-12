pipeline {
    agent any
    stages {
        stage('Example Build') {
            when {
                anyOf { 
			branch 'master'; branch 'stg' 
		}
            }
            steps {
                echo 'Hello World'
            }
        }
        stage('Example Deploy') {
            when {
                branch 'master'
            }
            steps {
                echo 'Deploying'
            }
        }
    }
}
