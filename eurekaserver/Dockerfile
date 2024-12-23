FROM maven:3.9.4-jdk21 as build
WORKDIR /app
COPY . .
RUN mnv clean package -DskipTests

FROM jdk:21
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
EXPOSE 8761
ENTRYPOINT java -jar app.jar