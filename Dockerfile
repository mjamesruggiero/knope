FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/knope.jar /knope/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/knope/app.jar"]
