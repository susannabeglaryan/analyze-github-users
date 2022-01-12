FROM gradle:jdk11 as build
MAINTAINER susanna.beglaryan@gmail.com
COPY src /home/app/src
COPY build.gradle /home/app
COPY gradlew /home/app
COPY gradle /home/app/gradle
RUN cd /home/app ; ls ; ./gradlew bootJar
RUN echo $(ls /home/app/build)


FROM openjdk:13-jdk-alpine
RUN mkdir /app
COPY --from=build /home/app/build/libs/app.jar /usr/local/lib/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]