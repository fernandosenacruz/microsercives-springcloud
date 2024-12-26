FROM maven:3.9.4-jdk21 as build
WORKDIR /app
COPY . .
RUN mnv clean package -DskipTests

FROM jdk:21
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar

ARG RABBITMQ_SERVER=rabbitmq-host
ARG EUREKA_SERVER=localhost

ENTRYPOINT java -jar -Dspring.profiles.active=production app.jar