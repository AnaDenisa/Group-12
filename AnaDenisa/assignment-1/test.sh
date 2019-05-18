#!/bin/bash

# The class which represents the entry point into JUnit.
readonly JUNIT_MAIN='org.junit.runner.JUnitCore'

# Go to the directory where the script is defined.
cd "$(dirname "$0")"

# Determine the list of test classes and place it into an array.
declare -a TEST_CLASSES=()
for test_filename in *Test.java; do
  # Strip the .java extension.
  TEST_CLASSES+=("${test_filename/.java/}")
done
# Run JUnit and pass the list of classes to it.
java -cp "$(./classpath)" "${JUNIT_MAIN}" "${TEST_CLASSES[@]}"
