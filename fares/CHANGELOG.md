# CHANGELOG

## History
### v0.0.1-SNAPSHOT (CURRENT RELEASE)

* Move Greeting service as a sub-module (an independent microservice) for Flyem Spring Boot project
* `#1` : Move current Greeting implementation as a sub-module, refactor and update class names
* `#2` : Update Dockerfile config accordingly (this project is not root anymore, it is a sub-module now)
* `#3` : Add a new build.gradle file for this sub-module in-line with root project's build.gradle file
* `#4` : Add a new deployment file for kubernetes for this sub-module
* `#5` : Add a separate README and CHANGELOG files for this microservice.
* `#6` : Add environments 'dev' and 'prod' for this microservice

## Feature

### (NEXT RELEASEs)

* Replace Greeting service with Fares Microservice which will return fare for a flight
* Add RabbitMQ or Kafka for interservice communication
* Add CI/CD processes