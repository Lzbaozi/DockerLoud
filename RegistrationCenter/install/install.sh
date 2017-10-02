#!/bin/bash

docker build -t dockerloud/registrationcenter .

docker save dockerloud/registrationCenter > /tmp/RegistrationCenter.tar