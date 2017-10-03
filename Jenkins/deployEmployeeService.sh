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
dos2unix install_employeeservice.sh.sh
chmod 777 install_employeeservice.sh.sh
./install_employeeservice.sh.sh

