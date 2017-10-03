#!/bin/bash

systemctl start docker

docker stop ConfigCenter
docker rm ConfigCenter
docker rmi dockerloud/configcenter

docker build -t dockerloud/configcenter .

rm -f /tmp/configcenter.tar

docker save dockerloud/configcenter > /tmp/configcenter.tar