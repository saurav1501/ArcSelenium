pipeline{
agent any
stages 
{
stage('Building Project') 
{
steps{
echo "Building the Code.........."
shell "mvn clean install"
}
}
stage('Excuting Code..') 
{
steps{
  wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: false, shutdownWithBuild: true ,displayNameOffset: 1,installationName: 'Xvfb', parallelBuild: true, screen: '1600x1280x24', timeout: 60])
  {
  sh "mvn -f pom.xml clean install"
}
}
}
  
 stage ('Test') {
      steps {
        // run tests with coverage
        sh 'bundle exec rake spec'
      }

      post {
        always {
          // publish html
             publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'Reports', reportFiles: 'ARC_UITestingReport_Building.html', reportName: 'ExtendReport', reportTitles: ''])
            
        }
      }
    
  
  post {
    always {
      echo "Send notifications for result: ${currentBuild.result}"
    }
  }
}
 }
}
