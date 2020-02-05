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
  wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: true, shutdownWithBuild: true ,displayNameOffset: 0,installationName: 'Xvfb', parallelBuild: true, screen: '1600x1280x24', timeout: 60]) {
    // some block
  } {
  sh "mvn -f pom.xml clean install"
}
}
}
}
}
