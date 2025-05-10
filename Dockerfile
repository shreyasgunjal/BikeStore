FROM openjdk:21

WORKDIR /app

COPY target/bike_store-0.0.1-SNAPSHOT.jar /app/bike_store-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "bike_store-0.0.1-SNAPSHOT.jar"]


