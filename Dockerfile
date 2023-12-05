FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/player*.jar player.jar
ENTRYPOINT ["java","-jar","/player.jar"]
