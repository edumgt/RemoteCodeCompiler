# Build stage
FROM maven:3.6.0 AS build
WORKDIR /compiler
COPY . .
RUN mvn clean install -Dmaven.test.skip=true

# Run stage
FROM eclipse-temurin:11-jre

WORKDIR /compiler

USER root

# docker.io 설치 (최신 Debian bookworm 기반)
RUN apt-get update && apt-get install -y --no-install-recommends docker.io \
    && rm -rf /var/lib/apt/lists/*

# 빌드된 JAR 복사
COPY --from=build /compiler/target/*.jar /compiler/compiler.jar

# 실행 관련 파일 복사
COPY executions /compiler/executions
COPY entrypoint.sh /compiler/entrypoint.sh

# 실행 권한 부여
RUN chmod +x /compiler/entrypoint.sh

EXPOSE 8082

ENTRYPOINT ["/compiler/entrypoint.sh"]
