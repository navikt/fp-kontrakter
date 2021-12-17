# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.192.0/containers/java/.devcontainer/base.Dockerfile

# [Choice] Java version: 11, 16
ARG VARIANT="16"
FROM mcr.microsoft.com/vscode/devcontainers/java:0-${VARIANT}

# [Option] Install Maven
ARG INSTALL_MAVEN="true"
ARG MAVEN_VERSION="3.8.3"

RUN if [ "${INSTALL_MAVEN}" = "true" ]; then su vscode -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install maven \"${MAVEN_VERSION}\""; fi

# [Optional] Uncomment this section to install additional OS packages.
# RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
#     && apt-get -y install --no-install-recommends <your-package-list-here>
