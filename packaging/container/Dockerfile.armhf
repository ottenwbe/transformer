FROM balenalib/rpi-openjdk:8-20190529

ARG JAR_FILE
COPY build/libs/${JAR_FILE} transformer.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/transformer.jar"]