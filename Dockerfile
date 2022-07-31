# syntax=docker/dockerfile:experimental
FROM openjdk:17-jdk-alpine AS build
WORKDIR /workspace/application

COPY . /workspace/application
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build
ARG APPLICATION_VERSION
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/${APPLICATION_VERSION}.jar)

FROM openjdk:17-jdk-alpine
EXPOSE 8080
EXPOSE 9090
VOLUME /tmp
ARG DEPENDENCY=/workspace/application/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.flyem.service.ServiceApplication"]