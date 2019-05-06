#!/bin/bash


# Go to the directory where the script is defined.
cd "$(dirname "$0")"
# Run JUnit and pass the list of classes to it.
java -jar ../../shared/google-java-format/google-java-format-1.7-all-deps.jar --replace *.java
