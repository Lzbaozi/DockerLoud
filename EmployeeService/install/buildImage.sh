#!/bin/bash

systemctl start docker

docker stop EmployeeService
docker rm EmployeeService
docker rmi dockerloud/employeeservice

docker build -t dockerloud/employeeservice .

rm -f /root/employeeservice.tar

docker save dockerloud/employeeservice > /root/employeeservice.tar