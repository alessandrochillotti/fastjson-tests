#!/bin/bash

PATH_JACOCO_CLI_JAR="/home/alessandro/software-testing/fastjson-tests/lib"
PATH_FJSON_SRC="/home/alessandro/software-testing/fastjson-source/fastjson/src/"
PATH_FJSON_JAR="/home/alessandro/software-testing/fastjson-tests/lib"

## ESTRAZIONE CON JACOCO DA CLI DEL REPORT:
mkdir -p target/jacoco-gen/fastjson-coverage/

java -jar ${PATH_JACOCO_CLI_JAR}/jacococli.jar report target/jacoco.exec --classfiles ${PATH_FJSON_JAR}/fastjson-1.2.79.jar --sourcefiles ${PATH_FJSON_SRC} --html target/jacoco-gen/fastjson-coverage/ --xml target/jacoco-gen/fastjson-coverage/file.xml --csv target/jacoco-gen/fastjson-coverage/file.csv
