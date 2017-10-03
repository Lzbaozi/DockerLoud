FROM docker.io/openjdk

EXPOSE 3333

COPY ./release_jars /release_jars

ENTRYPOINT java -Djava.ext.dirs=/release_jars com.dockerloud.employeeservice.Application

