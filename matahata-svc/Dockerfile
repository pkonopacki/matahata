FROM openjdk:8-jdk-alpine
COPY target/matahata-svc*.jar matahata-svc.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/matahata-svc.jar"]