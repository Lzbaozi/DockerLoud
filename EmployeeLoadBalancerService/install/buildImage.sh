#!/bin/bash

systemctl start docker

docker stop EmployeeBlancerService
docker rm EmployeeBlancerService
docker rmi dockerloud/employeeblancerservice

docker build -t dockerloud/employeeblancerservice .

rm -f /root/employeeblancerservice.tar

docker save dockerloud/employeeblancerservice > /root/employeeblancerservice.tar