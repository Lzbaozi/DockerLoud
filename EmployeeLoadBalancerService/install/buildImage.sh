#!/bin/bash

systemctl start docker

docker stop EmployeeLoadBalancerService
docker rm EmployeeLoadBalancerService
docker rmi dockerloud/employeeloadbalancerservice

docker build -t dockerloud/employeeloadbalancerservice .

rm -f /root/employeeloadbalancerservice.tar

docker save dockerloud/employeeloadbalancerservice > /root/employeeloadbalancerservice.tar