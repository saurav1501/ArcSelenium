pipeline{
agent any
stages 
{
stage('Build') 
{
steps{
echo "Building the Code.........."
shell "mvn clean install"
}
}
stage('Test') 
{
steps{
echo "Testing the Code.........."
sh "mvn -f pom.xml clean install"

}
}
stage('Compile') 
{
steps{
echo "Compiling the Project.........."
shell "mvn compile"
}
}
stage('Deploy') 
{
steps{
echo "Deploying the Project.........."
}
}
}
}
