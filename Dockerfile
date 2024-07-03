FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/sms-app.jar app/sms-app.jar
CMD ["java", "-jar", "sms-app.jar"]