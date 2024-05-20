FROM ubuntu:latest


RUN apt update && apt install -y openjd   k-21-jdk postgresql

WORKDIR /app
COPY target/*.jar /app
EXPOSE 8080
EXPOSE 5432

RUN service postgresql start && su - postgres -c 'createdb testdb Mirea_GPT'

CMD ["java", "-jar", "chat-0.0.1-SNAPSHOT.jar"]
