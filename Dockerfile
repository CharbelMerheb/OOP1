# Use an OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy built jar from local machine to container
COPY target/recipe-api-0.0.1-SNAPSHOT.jar app.jar

# Expose port Render uses
EXPOSE 10000

# Run the jar
CMD ["java", "-Dserver.port=10000", "-jar", "app.jar"]
