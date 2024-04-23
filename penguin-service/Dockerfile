FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.authors="Slawomir Wosek"
LABEL org.opencontainers.image.source="https://github.com/slawosek/Penguins"
LABEL org.opencontainers.image.url="https://github.com/slawosek/Penguins"
LABEL org.opencontainers.image.vendor="Slawomir Wosek"
LABEL org.opencontainers.image.version="0.0.1"
LABEL org.opencontainers.image.description="REST services for Penguin app."
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1"

ENV SPRING_DATASOURCE_URL="jdbc:h2:mem:remote-work"
ENV SPRING_DATASOURCE_DRIVERCLASSNAME="org.h2.Driver"
ENV SPRING_DATASOURCE_USERNAME="admin"
ENV SPRING_DATASOURCE_PASSWORD="password"
ENV SPRING_JPA_DATABASE_PLATFORM="org.hibernate.dialect.H2Dialect"

COPY target/penguin-service-${VERSION}.jar /opt/penguin-service/penguin-service.jar

CMD ["java", "-jar", "/opt/penguin-service/penguin-service.jar"]
