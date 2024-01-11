FROM amazoncorretto:17.0.9-alpine3.18

USER root
ENV \
  SWARM_MASTER=${SWARM_MASTER}\
  SWARM_USER=${SWARM_USER}\
  SWARM_PASS=${SWARM_PASS}\
  SWARM_EXECUTORS=${SWARM_EXECUTORS}\
  MAVEN_CACHE=${MAVEN_CACHE}
# Update and upgrade apk then install curl, maven, git, and nodejs
RUN apk update && \
  apk upgrade && \
  apk --no-cache add curl && \
  apk --no-cache add maven && \
  apk --no-cache add git && \
  apk --no-cache add docker

# Create workspace directory for Jenkins
RUN mkdir /workspace && \
  chmod 777 /workspace

# Download the latest Jenkins swarm client with curl - version 3.44
# Browse all versions here: https://repo.jenkins-ci.org/releases/org/jenkins-ci/plugins/swarm-client/
RUN wget https://repo.jenkins-ci.org/releases/org/jenkins-ci/plugins/swarm-client/3.44/swarm-client-3.44.jar

