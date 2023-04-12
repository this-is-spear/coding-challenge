FROM amazoncorretto:17
LABEL maintainer="rjsckdd12@gmail.com"

COPY build/libs/*.jar app.jar

ENV USE_PROFILE prod

ENV JAVA_TOOL_OPTIONS "-Dspring.profiles.active=${USE_PROFILE}"

ENTRYPOINT ["java","-jar","coding-analyzer.jar"]
