#!/bin/bash

docker stop RegistrationCenter
docker rm RegistrationCenter
docker rmi dockerloud/registrationcenter

docker build -t dockerloud/registrationcenter .

rm -f /tmp/registrationcenter.tar

docker save dockerloud/registrationcenter > /tmp/registrationcenter.tar