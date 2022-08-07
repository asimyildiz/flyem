# syntax=docker/dockerfile:experimental
FROM openjdk:17-jdk-alpine AS build
ENV APPLICATION_PATH /workspace/service
WORKDIR ${APPLICATION_PATH}

COPY ./search ${APPLICATION_PATH}/search
COPY build.gradle settings.gradle ${APPLICATION_PATH}
COPY gradlew ${APPLICATION_PATH}
COPY gradle ${APPLICATION_PATH}/gradle

RUN --mount=type=cache,target=/root/.gradle ./gradlew clean :search:build
ARG APPLICATION_VERSION
RUN mkdir -p ${APPLICATION_PATH}/search/build/dependency && (cd ${APPLICATION_PATH}/search/build/dependency; jar -xf ../libs/${APPLICATION_VERSION}.jar)

FROM openjdk:17-jdk-alpine
ENV APPLICATION_PATH /workspace/service
EXPOSE 8080
EXPOSE 9090
VOLUME /tmp
ARG DEPENDENCY=${APPLICATION_PATH}/search/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.flyem.microservice.SearchApplication"]