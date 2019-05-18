#!/bin/bash

# The class defining the main function.
readonly MAIN_CLASS='Main'

# Go to the directory where the script is defined.
cd "$(dirname "$0")"
# Run the main class and pass the script arguments to it.
java -cp "$(./classpath)" "${MAIN_CLASS}" "$@"
