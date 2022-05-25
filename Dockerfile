FROM azul/zulu-openjdk-alpine:11
COPY build/libs/helpdesk-dores-0.0.1-SNAPSHOT.jar helpdesk-dores.jar
EXPOSE 8080
CMD ["java", "-jar", "helpdesk-dores.jar"]