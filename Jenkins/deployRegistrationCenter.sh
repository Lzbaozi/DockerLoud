#!/bin/bash

cd /root/dockerloud/DockerLoud
git pull https://github.com/Lzbaozi/DockerLoud.git

cd RegistrationCenter
mvn clean install

dos2unix buildImage.sh
chmod 777 buildImage.sh
./buildImage.sh

dos2unix install_registrationcenter.sh
chmod 777 install_registrationcenter.sh
./install_registrationcenter.sh

