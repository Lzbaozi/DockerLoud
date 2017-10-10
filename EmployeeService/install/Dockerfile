FROM docker.io/openjdk

EXPOSE 3333

COPY ./release_jars /release_jars

ENTRYPOINT java -Djava.ext.dirs=/release_jars -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 com.dockerloud.employeeservice.Application


