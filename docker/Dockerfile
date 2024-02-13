FROM amazoncorretto:21 as builder
ARG JAR_FILE=target/graalvm-0.0.1.jar
COPY ${JAR_FILE} graalvm-0.0.1.jar
ENV TZ="Europe/Minsk"
ENTRYPOINT ["java","-jar","graalvm-0.0.1.jar"]
