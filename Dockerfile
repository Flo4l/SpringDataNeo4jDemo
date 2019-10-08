FROM openjdk:11-jre-slim

WORKDIR /app

COPY ./target/*.jar ./app.jar

EXPOSE 80
EXPOSE 7687

ENTRYPOINT ["java","-jar","app.jar"]