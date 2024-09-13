FROM openjdk:17-jdk-alpine

RUN apk add --no-cache curl
WORKDIR /data/banco-base-web-api/
RUN mkdir -p /data/banco-base-web-api/cfg/

COPY code-challenge-web-api.jar /data/banco-base-web-api/code-challenge-web-api.jar 
COPY entrypoint-banco-base-web-api.sh /data/entrypoint-banco-base-web-api.sh
COPY application.properties /data/banco-base-web-api/cfg/application.properties

RUN chmod 755 /data/entrypoint-banco-base-web-api.sh

#Container deployment
EXPOSE 8080
ENTRYPOINT ["/data/entrypoint-banco-base-web-api.sh"]
