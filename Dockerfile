FROM maven:3.8.5-openjdk-17

WORKDIR /gateway

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:17-jdk

COPY /target/api-gateway-0.0.1-SNAPSHOT.jar /gateway/launch-gateway.jar

ENTRYPOINT ["java","-jar","/gateway/launch-gateway.jar"]

EXPOSE 8765