FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

# Make gradlew executable
RUN chmod +x gradlew

# Build the app
RUN ./gradlew build -x test

EXPOSE 8080

CMD ["java", "-jar", "build/libs/spotify-0.0.1-SNAPSHOT.jar"]
