# Automation API Task for Dev.Challenge QA #1
- Requires Java 8 to be installed on the PC (not tested with Java versions higher than 1.8)
- Requires Maven to be installed on the PC

## How to run tests:
- Clone/Download project from GitHub
- To RUN all tests, execute following from CMD (console) in project root:
> mvn clean test

## About config.properties file
> While changing values from this file, this values will be changed in a whole project
- url.base=http://petstore.swagger.io // base Url to APP
- url.path=/v2/pet // Path to API
- pet.name=Dog // String used for Tests
- pet.id=666 // Value that will be assigned as ID

!Feel fre to change pet.name, and pet.id to check your scenarios