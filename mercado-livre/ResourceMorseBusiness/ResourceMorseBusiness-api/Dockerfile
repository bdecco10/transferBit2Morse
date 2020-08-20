FROM openjdk:8-jdk-alpine
ENV spring.profiles.active=desenv
ENV mercadolivre.host=config-server
ENV mercadolivre.port=9080
ARG NAME_APP
ENV resource.url=${NAME_APP}
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]