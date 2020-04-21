FROM openjdk:8
VOLUME /tmp
EXPOSE 8090
ADD ./target/ticket-microservice-0.0.1-SNAPSHOT.jar ticket-microservice.jar
ENTRYPOINT ["java", "-jar", "/ticket-microservice.jar"]