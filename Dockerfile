FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

ADD target/fleetflow-github-actions.jar fleetflow-github-actions.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/fleetflow-github-actions.jar"]
