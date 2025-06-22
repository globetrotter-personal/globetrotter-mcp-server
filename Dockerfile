FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Install Maven and build the application
RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean package -DskipTests && \
    apt-get remove -y maven && \
    apt-get autoremove -y && \
    rm -rf /var/lib/apt/lists/*

# Copy the built JAR file
COPY target/globetrotter-mcp-server-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8082

# Set the entry point
ENTRYPOINT ["java", "-jar", "app.jar"]
