#FROM  maven:3.8.6-openjdk-11-slim
#MAINTAINER QIANG@example.com
#COPY src /app/src
#COPY pom.xml /app
#RUN mvn -f /app/pom.xml clean package
#ENTRYPOINT ["java","-jar","/app/target/spring-boot-docker-1.0.0.jar"]



#FROM maven:3.8.6-openjdk-11-slim AS build
#COPY src /app/src
#COPY C:\\Users\\Qiang\\.m2 /root/.m2
#COPY pom.xml /app
#RUN mvn -f /app/pom.xml -T 4C  clean package
#
#FROM eclipse-temurin:17-jre-alpine
#ARG DEPENDENCY=/app/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]


##187mb
FROM eclipse-temurin:17-jre-alpine
COPY target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]

#240
#FROM openjdk:11-jre-slim
#COPY target/*.jar /app/app.jar
#ENTRYPOINT ["java","-jar","/app/app.jar"]

#340
#FROM openjdk:17-alpine
#COPY target/*.jar /app/app.jar
#ENTRYPOINT ["java","-jar","/app/app.jar"]