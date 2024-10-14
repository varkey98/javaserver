FROM ubuntu:24.04
RUN apt update -y && apt install openjdk-17-jdk -y
ARG JAR_FILE=build/libs/javaserver-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY javaagent-1.1.14-prerelease.2-SNAPSHOT.jar agent.jar
ENTRYPOINT ["java","-javaagent:agent.jar","--enable-native-access=ALL-UNNAMED","--add-opens","java.base/java.lang=ALL-UNNAMED","-jar","/app.jar"]