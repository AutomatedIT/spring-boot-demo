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
        // copy the newly created application jar file in to place
        sh "cp ./build/libs/cicdjenkins*.jar /app.jar"
    }
    stage('Run SpringBoot Application') {
        // run the application inside the container on port 80
        // and background it so we can carry on and test it
        sh "nohup /usr/bin/java -jar -Dspring.profiles.active=test -Dserver.port=80 /app.jar &"
    }
    stage('Test SpringBoot Application') {
        // keep trying until it's ready, then perform test(s) to verify...
        sh "until curl -k localhost; do sleep 1; done;"
    }
    stage('Stop SpringBoot Application') {
        // kill the backgrounded process
        sh "kill -9 `ps -eaf | grep spring | grep profile | awk '{print \$2}'` | :"
    }
    stage('Archive results') {
        // archive things we may want to keep alongside the corresponding build
        // like the application jar file, test results, any log files etc...
        archiveArtifacts artifacts: 'build/libs/cicdjenkins*.jar, build/test-results/test/TEST*.xml'
    }   
}
