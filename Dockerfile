FROM gradle:8.11.1-jdk21
WORKDIR /app
COPY . .
RUN gradle clean build -x test
COPY build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
