pipeline{
agent any
stages 
{
stage('Build') 
{
steps{
echo "Building the Code.........."
shell "mvn clean"
}
}
stage('Test') 
{
steps{
echo "Testing the Code.........."
shell "mvn test"
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