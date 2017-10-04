FROM docker.io/openjdk

EXPOSE 2222

COPY ./release_jars /release_jars

ENTRYPOINT java -Djava.ext.dirs=/release_jars com.dockerloud.balancer.employeeservice.Application

