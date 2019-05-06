#!/bin/bash

# Go to the directory where the script is defined.
cd "$(dirname "$0")"
# Compile all Java files within this directory.
javac -cp "$(./classpath)" -d classes *.java
