FROM openjdk:21-jdk

# Set the working directory
WORKDIR /job4j_devops

# Copy the built JAR file from the builder stage
COPY --from=builder /job4j_devops/build/libs/DevOps-1.0.0.jar .

# Extract the JAR if needed
RUN jar xf DevOps-1.0.0.jar

# Command to run the application
CMD ["java", "-jar", "DevOps-1.0.0.jar"]