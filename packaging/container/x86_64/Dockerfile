FROM openjdk:8u212-stretch

ARG JAR_FILE
COPY build/libs/${JAR_FILE} transformer.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/transformer.jar"]