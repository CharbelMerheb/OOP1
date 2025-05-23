# -------- STAGE 1: Build the JAR --------
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# -------- STAGE 2: Run the JAR --------
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 10000
CMD ["java", "-Dserver.port=10000", "-jar", "app.jar"]
