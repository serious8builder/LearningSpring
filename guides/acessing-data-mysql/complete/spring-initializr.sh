#!/bin/sh

curl https://start.spring.io/starter.zip -d dependencies=web,data-jpa,lombok \
  -d groupId=com.example -d artifactId=accessing-data-mysql \
  -d packageName=com.example.accessingdatamysql -d name=accessing-data-mysql \
  -d language=java -d type=maven-project -d javaVersion=1.8 \
  -o application.zip