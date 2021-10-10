# kubernetes-configmap-reload
ConfigMap reload example change the spring boot application properties in runtime


### Short kickoff
1. Clone and build the project
```
git clone https://github.com/mbaykara/spring-cloud-kubernetes.git
cd spring-cloud-kubernetes
mvn package
```
2. Build the docker image
```
docker build -t [yourRegistry]/springcloud
docker push [yourRegistry]/springcloud
```
3. Modify the `k8s/deployment.yaml` file by replacing image name with your fresh built image
```
image: baykara/springcloud -> image:  [yourRegistry]/springcloud
```
4. Deploy via `kubectl`
```
kubectl apply -f k8s/
```
Check the logs 
5. Appy the configmap via 
```
kubectl apply -f config.yaml
```
Check the logs again and see the diffence!
## Test the endpoints
 Lets test it without creating service on Kubernetes
 Simply: 
```
 kubectl port-forward [pod-name] 8080
```
then
```
curl localhost:8080/version
```
and 

```
curl localhost:8080/name
```