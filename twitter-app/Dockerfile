FROM java:openjdk-8-jre

WORKDIR /prod/program/bootapp
ADD setenv.sh setenv.sh
ADD build/libs/twitter-app.jar app.jar

EXPOSE 8080
VOLUME ["/prod/logs/bootapp", "/prod/logs/bootapp/gc"]
CMD java -Dspring.profiles.active=production -jar app.jar
