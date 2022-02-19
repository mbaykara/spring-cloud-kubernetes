# kubernetes-configmap-reload
ConfigMap reload example change the spring boot application properties in runtime
Configuration watcher will observe secrets and configmap objects, if any modification happens on them, it will make
an api call on /refresh endpoint on springboot applicaiton. Then the new properties will be applied.


```
mvn compile jib:build -Djib.to.tags=k8s
```