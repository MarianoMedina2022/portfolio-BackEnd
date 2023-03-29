FROM amazoncorretto:11-alpine-jdk
MAINTAINER MedinaMariano
COPY target/medinamariano-0.0.1-SNAPSHOT.jar medina-app.jar
ENTRYPOINT ["java","-jar","/medina-app.jar"]
