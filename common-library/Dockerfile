# Use the official OpenJDK image as a base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from your host to the container's working directory
COPY target/common-library-1.0-SNAPSHOT.jar common-library.jar

# Run the JAR file
CMD ["java", "-jar", "common-library.jar"]
