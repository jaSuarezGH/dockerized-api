# Etapa de compilación
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/dockerized-api-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]