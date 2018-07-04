node {
    echo 'Hello World'
    stage('Checkout From GitHub') {
        git url: 'https://github.com/AutomatedIT/springbootjenkinspipelinedemo.git', branch: 'master'
    }
    stage('Run Gradle Build') {
        sh "./gradlew clean build"
    }
    stage('Transfer Artefacts') {
        sh "cp ./build/libs/cicdjenkins*.jar /app.jar"
    }
    stage('Run SpringBoot Application') {
        sh "nohup /usr/bin/java -jar -Dspring.profiles.active=test -Dserver.port=80 /app.jar &"
    }
    stage('Test  SpringBoot Application') {
        sh "sleep 20; curl -k localhost"
    }
    stage('Stop  SpringBoot Application') {
        sh "kill -9 `ps -eaf | grep spring | grep profile | awk '{print \$2}'`"
    }
}
