#!/bin/env bash

kubectl delete -f k8s/
var=$(date "+%S")
mvn compile jib:build -Djib.to.tags=$var
