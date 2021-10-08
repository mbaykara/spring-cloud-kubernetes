#!/bin/env bash

kubectl delete -f k8s/
mvn clean package

echo "Building and pushing docker image to docker hub"

docker build -t baykara/springcloud .
echo "Image is pushing to registry..."
docker push baykara/springcloud


echo "Deploying to Kubernetes Cluster..."

kubectl apply -f k8s/