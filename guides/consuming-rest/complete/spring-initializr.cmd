#!/bin/sh

curl https://start.spring.io/starter.zip -d dependencies=web \
  -d groupId=com.example -d artifactId=consumming-rest \
  -d packageName=com.example.consumingrest -d name=consumming-rest \
  -d language=java -d type=maven-project -d javaVersion=1.8 \
  -o application.zip
