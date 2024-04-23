#!/usr/bin/env bash

# Builds docker image using Dockerfile and tags it based on org.opencontainers.image.version label in Dockerfile.

#######################################
# Script main function. Builds docker image using Dockerfile and tags it based on org.opencontainers.image.version label
# in Dockerfile.
# Arguments:
#   None.
#######################################
function main() {
    cd ./penguin-service/; sh ./build.sh; cd ..
    cd ./penguin-ng/; sh ./build.sh; cd ..
}

main "$@"