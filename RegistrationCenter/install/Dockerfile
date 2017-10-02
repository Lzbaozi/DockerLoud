FROM docker.io/openjdk

EXPOSE 1111

COPY ./release_jars /release_jars

ENTRYPOINT java -Djava.ext.dirs=/release_jars com.dockerloud.regcenter.app.Application

