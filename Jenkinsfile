node {
    echo 'Hello World'
    stage('Checkout From GitHub') {
        git url: 'https://github.com/AutomatedIT/springbootjenkinspipelinedemo.git', branch: 'master'
        sh "find ."
    }
    stage('Run Gradle Build') {
        sh "./gradlew clean build"
    }
    stage('Transfer Artefacts') {
        sh "cp ./build/libs/cicdjenkins*.jar /app.jar"
    }
    stage('Run SpringBoot Application') {
        sh "/usr/bin/java -jar -Dspring.profiles.active=test -Dserver.port=80 /app.jar"
    }
}
