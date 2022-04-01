FROM openjdk:8
EXPOSE 8000
ADD target/gateway.jar gateway.jar
ENTRYPOINT ["java","-jar","gateway.jar"]