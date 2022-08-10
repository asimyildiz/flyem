# CHANGELOG

## History
### v0.0.8-SNAPSHOT (CURRENT RELEASE)

* Use version catalog to manage dependencies inside gradle with groovy
* `#19`: Add dependencies into settings.gradle as a version catalog and update all dependencies using this catalog

### v0.0.7-SNAPSHOT (PREVIOUS RELEASE)

* Add Search microservice, update Fare microservice, add RabbitMQ message broker
* `#15`: Add search microservice with it's own sub-project and rabbitmq receiver
* `#16`: Update fare microservice, add update fare method, add rabbitmq sender
* `#17`: Add a gradle.properties file to run gradle tasks in parallel
* `#18`: Update README and CHANGELOG for the root project

### v0.0.6-SNAPSHOT (PREVIOUS RELEASE)

* Use gradle sub-projects in order to implement our microservices independently. 
* `#11`: Move our initial service and Greeting implementation as a sub-project (a new microservice) with it's own gradle and Dockerfile
* `#12`: Update build.gradle and settings.gradle for the root project
* `#13`: Update README and CHANGELOG for the root project
* `#14`: Move and create Kubernetes deployment configs for microservices into root project

### v0.0.5-SNAPSHOT (PREVIOUS RELEASE)

* Add logging mechanism for our current Spring Boot Application 
* `#9` : Add step by step installation and running of ELK stack into README.md file. Add sample configuration files for ELK stack.
* `#10`: Add logging using "org.slf4j.Logger" package with a basic configuration

### v0.0.4-SNAPSHOT (PREVIOUS RELEASE)

* Add Kubernetes as orchestrator using the Docker image of our current Spring Boot Application
* `#8` : Create a deployment YAML file that Kubernetes uses to run the service, add steps into README.md file

### v0.0.3-SNAPSHOT (PREVIOUS RELEASE)

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

* Add a new Search microservice with it's tests
* Add Cassandra or Redis as Backend
* Add RabbitMQ or Kafka for interservice communication
* Add CI/CD processes