#!/usr/bin/env bash

if [[ -z "${TRANSFORMER_VERSION}" ]]; then
    echo "No env TRANSFORMER_VERSION defined"
    exit -1
fi

echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin

echo "Pushing ${TRANSFORMER_VERSION}"
docker push "ottenwbe/transformer:${TRANSFORMER_VERSION}"
docker push "ottenwbe/transformer:armhf-${TRANSFORMER_VERSION}"

echo "Tagging ${TRANSFORMER_VERSION}"
docker tag "ottenwbe/transformer:${TRANSFORMER_VERSION}" "ottenwbe/transformer:snapshot"
docker tag "ottenwbe/transformer:armhf-${TRANSFORMER_VERSION}" "ottenwbe/transformer:armhf-snapshot"
docker push "ottenwbe/transformer:armhf-snapshot"
docker push "ottenwbe/transformer:snapshot"