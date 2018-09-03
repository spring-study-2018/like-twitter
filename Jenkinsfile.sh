#!/usr/bin/env bash
####################################################################
##
## It is not a script to run on the actual Jenkins server.
## It tells you what to do on the CI(like Jenkins) server.
##
## CI server requirements
##  - JDK >= 8
##  - git core
##  - docker engine
##
####################################################################

## 1. Clone git repository
# checkout the current version of source code
git pull origin master

## 2. Build and test
# build projects under the gradle
./gradlew clean build
# check test reports
# TODO

## 3. Back docker images and push
# bake docker images
docker build -t kimtis/twitter/app:latest twitter-app
docker build -t kimtis/twitter/web:latest twitter-web
docker build -t kimtis/twitter/nginx:latest twitter-nginx
# upload docker images
# TODO
