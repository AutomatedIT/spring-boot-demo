node {
    stage('Checkout From GitHub') {
        // pull the java source code and gradle build files from GitHub
        git url: 'https://github.com/AutomatedIT/springbootjenkinspipelinedemo.git', branch: 'master'
    }
    stage('Run Gradle Build') {
        // build the application inside the docker container
        sh "./gradlew clean build"
    }
    stage('Transfer Artefacts') {
        // copy the newly created jar in to place
        sh "cp ./build/libs/cicdjenkins*.jar /app.jar"
    }
    stage('Run SpringBoot Application') {
        // run the application inside the container on port 80
        // and background it so we can carry on and test it
        sh "nohup /usr/bin/java -jar -Dspring.profiles.active=test -Dserver.port=80 /app.jar &"
    }
    stage('Test  SpringBoot Application') {
        // siplest test to verify if something has been deployed or not...
        sh "sleep 20; curl -k localhost"
    }
    stage('Stop  SpringBoot Application') {
        // kill the backgroun process
        sh "kill -9 `ps -eaf | grep spring | grep profile | awk '{print \$2}'`"
    }
    stage('Archive results') {
        // archive things we may want, liek the application jar file, test results, log files etc...
    }   
}
