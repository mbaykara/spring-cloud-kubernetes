#!/bin/env bash

mvn clean package

echo "Your docker username"

docker build -t baykara/springcloud .
echo "Image is pushing to registry..."
docker push baykara/springcloud


echo "For Deploying to Kubernetes Cluster"
echo "replace "
kubectl apply -f k8s/