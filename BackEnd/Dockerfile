FROM amazoncorretto:11-alpine-jdk 
MAINTAINER MV
COPY target/mv-0.0.1-SNAPSHOT.jar mv-app.jar
ENTRYPOINT ["java","-jar","/mv-app.jar"]
EXPOSE 8080
