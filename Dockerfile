FROM openjdk:8u151-jdk-alpine3.7

ENV APP_USER java

RUN adduser -S $APP_USER

RUN mkdir -p /usr/local/apps/rest-services-api

# Add the service itself
ARG JAR_FILE
ADD ${JAR_FILE} /usr/local/apps/rest-services-api/app.jar

RUN sh -c 'touch /usr/local/apps/rest-services-api/app.jar'

RUN mkdir -p /var/log && chown $APP_USER /var/log

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/usr/local/apps/rest-services-api/app.jar"]

EXPOSE 1443 8443