FROM docker.io/openjdk

EXPOSE 5555

COPY ./release_jars /release_jars

ENTRYPOINT java -Djava.ext.dirs=/release_jars com.dockerloud.configcenter.app.Application

