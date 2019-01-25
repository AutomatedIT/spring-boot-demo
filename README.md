# spring-boot-demo
SPRING BOOT DEMO APP

running on http://localhost:8080

### TO COMPILE

Checkout the contents of the repo

'''./gradlew build'''

### TO BUILD A DOCKER IMAGE

docker build -t automateditsolutions/demo_app:latest .

### TO RUN THE DEMO APP 

docker run -d --name sprint-boot-demo -p 8080:8080 automateditsolutions/demo_app:latest
