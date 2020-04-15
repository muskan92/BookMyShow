FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


# docker container run --network bookmyshownetwork --name muskan-bookmyshow-mysql-container -p 8009:8004 -d bookmyshow:1
