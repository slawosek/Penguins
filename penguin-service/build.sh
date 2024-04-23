#!/usr/bin/env bash

# Builds docker image using Dockerfile and tags it based on org.opencontainers.image.version label in Dockerfile.

#######################################
# Script main function. Builds docker image using Dockerfile and tags it based on org.opencontainers.image.version label
# in Dockerfile.
# Arguments:
#   None.
#######################################
function main() {
    JAVA_HOME=/usr/lib/jvm/java-17 mvn clean install site
    version="$(grep -n "org.opencontainers.image.version" Dockerfile | cut -f2 -d "=" | xargs)"
    docker build \
      --label "org.opencontainers.image.created=$(date +%Y-%m-%dT%H:%M:%S%:z)" \
      --label "org.opencontainers.image.ref.name=$(git rev-parse HEAD)" \
      --label "org.opencontainers.image.revision=$(git rev-parse HEAD)" \
      -t "swosek/penguin-service:${version}" .
}

main "$@"
