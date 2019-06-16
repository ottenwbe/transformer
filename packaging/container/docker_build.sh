#!/usr/bin/env bash

if [[ -z "${TRANSFORMER_VERSION}" ]]; then
    echo "No env TRANSFORMER_VERSION defined"
    exit -1
fi

docker build --build-arg JAR_FILE=transformer-${TRANSFORMER_VERSION}.jar -f packaging/container/x86_64/Dockerfile -t ottenwbe/transformer:${TRANSFORMER_VERSION} .
docker build --build-arg JAR_FILE=transformer-${TRANSFORMER_VERSION}.jar -f packaging/container/armhf/Dockerfile -t ottenwbe/transformer:armhf-${TRANSFORMER_VERSION} .