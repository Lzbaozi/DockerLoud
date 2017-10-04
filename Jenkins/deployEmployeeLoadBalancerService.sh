#!/bin/bash

cd /root/dockerloud/DockerLoud
#git fetch https://github.com/Lzbaozi/DockerLoud.git
git fetch --all  
git reset --hard origin/master 
git pull

cd EmployeeService
mvn clean install

cd release_folder
dos2unix buildImage.sh
chmod 777 buildImage.sh
./buildImage.sh

cd ../../AnsiblePlayBooks/
dos2unix install_employeeloadbalancerservice.sh
chmod 777 install_employeeloadbalancerservice.sh
./install_employeeloadbalancerservice.sh

