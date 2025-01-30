# Hackathon FEEL the context

This demo project for https://github.com/camunda/camunda/pull/27527.

It contains a simple process application with a job worker implementation and the process resources (BPMN+Forms).

## How to play

1. Configure the distribution: Add the env variable to the Camunda container `CUSTOM_HOTLINE=+49 30 664 04 09 00`
2. Start the distribution
3. Start the application
4. Create a new instance of the v1 process
5. Complete the user forms
6. Deploy and create a new instance of the v2 process (new activity in the ad-hoc subprocess)
7. Complet the user forms

