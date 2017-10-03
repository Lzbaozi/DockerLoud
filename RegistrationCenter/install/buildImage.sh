#!/bin/bash

systemctl start docker

docker stop RegistrationCenter
docker rm RegistrationCenter
docker rmi dockerloud/registrationcenter

docker build -t dockerloud/registrationcenter .

rm -f /root/registrationcenter.tar

docker save dockerloud/registrationcenter > /root/registrationcenter.tar