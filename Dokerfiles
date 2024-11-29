FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/*-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
# 도커 컨테이너를 시작할 때 실행할 명령어
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]