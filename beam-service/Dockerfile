# Use a base image with Java 17 and Alpine Linux
FROM openjdk:17-oracle

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container at /app
COPY target/beam-service-1.jar /app/app.jar

# Expose the port the app runs on
EXPOSE 8082

# Specify the command to run on container start
CMD ["java", "-jar", "app.jar"]
