# spring-boot-demo
SPRING BOOT DEMO APP

running on http://localhost:8080

TO COMPILE
Checkout the contents of the repo
./gradlew build

TO BUILD A DOCKER IMAGE
Create a DOCKERFILE
# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jre-alpine
# copy application WAR (with libraries inside)
COPY springbootdemo*.jar /app.jar
# specify default command
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/app.jar"]

TO BUILD
docker build -t automateditsolutions/demo_app:latest .

TO RUN THE DEMO APP
docker run -d --name sprint-boot-demo -p 8080:8080 automateditsolutions/demo_app:latest
