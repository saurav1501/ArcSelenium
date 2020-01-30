node{
    stage('Scm Checkout'){
    git = 'https://github.com/saurav1501/ArcSelenium'
    }
stage('Compile-Package'){
def mvnHome= tool name: 'MAVEN', type: 'maven'
sh = "${mvnHome}/bin/mvn package"
}
}   
