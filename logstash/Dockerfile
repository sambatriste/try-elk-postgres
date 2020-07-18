FROM docker.elastic.co/logstash/logstash:7.8.0

RUN rm -rf /usr/share/logstash/pipeline
COPY pipeline /usr/share/logstash/pipeline
COPY postgresql-42.2.14.jar /usr/share/logstash/postgresql-42.2.14.jar
