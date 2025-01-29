FROM amazoncorretto:21

COPY /target/square_game-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "square_game-0.0.1-SNAPSHOT.jar"]