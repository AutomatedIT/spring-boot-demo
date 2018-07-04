node {
    stage('Checkout From GitHub') {
        // pull the java source code and gradle build files from GitHub
        git url: 'https://github.com/AutomatedIT/springbootjenkinspipelinedemo.git', branch: 'master'
    }
    stage('Build SpringBoot Application') {
        // build the application from source inside the docker container using gradle
        sh "./gradlew clean build"
    }
    stage('Transfer Build Output') {
        // copy the newly created jar in to place
        sh "cp ./build/libs/cicdjenkins*.jar /app.jar"
    }
    stage('Run SpringBoot Application') {
        // run the application inside the container on port 80
        // and background it so we can carry on and test it
        sh "nohup /usr/bin/java -jar -Dspring.profiles.active=test -Dserver.port=80 /app.jar &"
    }
    stage('Test  SpringBoot Application') {
        // give it a moment to start up then perform a basic test to verify if something has been deployed or not...
        sh "sleep 10; curl -k localhost"
    }
    stage('Stop  SpringBoot Application') {
        // kill the backgrounded process
        sh "kill -9 `ps -eaf | grep spring | grep profile | awk '{print \$2}'` | :"
    }
    stage('Archive results') {
        // archive things we may want, like the application jar file, test results, log files etc...
        archiveArtifacts artifacts: 'build/libs/cicdjenkins*.jar'
    }   
}
