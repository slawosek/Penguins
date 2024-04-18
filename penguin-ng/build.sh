#!/usr/bin/env bash

# Builds docker image using Dockerfile and tags it based on org.opencontainers.image.version label in Dockerfile.

#######################################
# Script main function. Builds docker image using Dockerfile and tags it based on org.opencontainers.image.version label
# in Dockerfile.
# Arguments:
#   None.
#######################################
function main() {

    if ! npm install; then
	exit 1;
    fi

    if ! npm run test; then
        exit 1;
    fi

    export NODE_OPTIONS=--openssl-legacy-provider

    if ! npm run e2e; then
        exit 1;
    fi

    if ! npm run build; then
        exit 1;
    fi

    if ! npm run site; then
        exit 1;
    fi

    echo "ok"

    version="$(grep -n "org.opencontainers.image.version" Dockerfile | cut -f2 -d "=" | xargs)"
    docker build \
      --label "org.opencontainers.image.created=$(date +%Y-%m-%dT%H:%M:%S%:z)" \
      --label "org.opencontainers.image.ref.name=$(git rev-parse HEAD)" \
      --label "org.opencontainers.image.revision=$(git rev-parse HEAD)" \
      -t "swosek/penguin-ng":"${version}" .
}

main "$@"
