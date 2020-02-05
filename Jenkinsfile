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
  wrap([$class: 'Xvfb', installationName: 'Xvfb', screen: '1600x1280x24',parallelBuild: true, timeout: 60]) {
  sh "mvn -f pom.xml clean install"
}
}
}
}
}
