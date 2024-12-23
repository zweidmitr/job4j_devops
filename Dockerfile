FROM openjdk:21-jdk as builder

COPY . .

RUN jar xf /build/libs/DevOps-1.0.0.jar

CMD ["java", "-jar", "DevOps-1.0.0.jar"]