#!/bin/bash

docker build -t dockerloud/RegistrationCenter .

docker save dockerloud/RegistrationCenter > /tmp/RegistrationCenter.tar