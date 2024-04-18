FROM nginx:1.23.3

LABEL org.opencontainers.image.authors="Slawomir Wosek"
LABEL org.opencontainers.image.source="https://github.com/slawosek/Penguins"
LABEL org.opencontainers.image.url="https://github.com/slawosek/Penguins"
LABEL org.opencontainers.image.vendor="Slawomir Wosek"
LABEL org.opencontainers.image.version="0.0.1"
LABEL org.opencontainers.image.description="Penguin managment frontend app."
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1"

ENV API_URL http://localhost:8080/api

ADD dist/penguin-ng/browser /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/

CMD ["nginx", "-g", "daemon off;"]
