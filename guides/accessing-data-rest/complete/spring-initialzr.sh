#!/bin/sh
curl https://start.spring.io/starter.zip -d dependencies=web,data-jpa,data-rest,h2,lombok \
  -d groupId=com.example -d artifactId=accessing-data-rest \
  -d packageName=com.example.accessingdatarest -d name=accessing-data-rest \
  -d language=java -d type=maven-project -d javaVersion=1.8 \
  -d platformVersion=2.4.3.RELEASE \
  -o application.zip

