FROM openjdk:11-jre-slim-buster
ENV TZ="Asia/Calcutta"
ARG JAR_FILE=./target/hrms-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /usr/app/hrms.jar
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","hrms.jar"]