# CHANGELOG

## History

### v0.0.3-SNAPSHOT (CURRENT RELEASE)

* Add Docker for containerization of the current Spring Boot Application
* `#7` : Add an optimized Dockerfile which extracts the layers from jar file for faster build and start up times

### v0.0.2-SNAPSHOT (PREVIOUS RELEASE)

* Start adding javadoc comments to code, add API documentation and Swagger for the current Spring Boot Application
* `#4` : Add javadoc comments to code
* `#5` : Add springdoc-openapi to generate Open API Documentation and Swagger
* `#6` : Update management port to 9090

### v0.0.1-SNAPSHOT (PREVIOUS RELEASE)

* Initial version that has a greeting service and actuators for monitoring
* `#0` : Initialize project using Spring Boot Initializr with Gradle as build automation tool
* `#1` : Add Lombok to minimize/remove the boilerplate code by using annotations
* `#2` : Add a Greeting Service with it's Model and Controller
* `#3` : Add tests for Greeting Service

## Feature

### (NEXT RELEASEs)

* Run the application on Kubernetes (using minikube with kubectl on local machine)
* Add a new Search microservice with it's tests
* Add Cassandra or Redis as Backend
* Add RabbitMQ or Kafka for interservice communication
* Add CI/CD processes