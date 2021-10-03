FROM adoptopenjdk/openjdk11

COPY ./target/kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["/bin/sh","-c","java -jar kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar"]