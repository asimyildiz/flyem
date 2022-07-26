# CHANGELOG

## History
### v0.0.5-SNAPSHOT (CURRENT RELEASE)

* Use the configuration file from configserver project using Spring Cloud
* `#19` : Add Spring Cloud Starter Config to get the configuration file over network

### v0.0.4-SNAPSHOT (PREVIOUS RELEASE)

* Add a message broker to inform other microservices when a fare updated
* `#13`: Add Spring Boot AMQP (Advanced Messaging Queuing Protocol) package, implement RabbitMQ sender
* `#14`: Add a new method to Fare model to prepare data to be sent over RabbitMQ
* `#15`: Add a PUT method (a new service) that updates a fare value to controller
* `#16`: Add new service methods to query service in order to run get a fare by id and update it on our repository
* `#17`: Add a new service exception to be fired when no fare data is found by id
* `#18`: Remove unnecessary lombok annotations on Fare class

### v0.0.3-SNAPSHOT (PREVIOUS RELEASE)

* Add missing currency property into fare entity model
* `#12`: Add currency into Fare entity

### v0.0.2-SNAPSHOT (PREVIOUS RELEASE)

* Implement Fares microservice for Flyem Spring Boot project
* `#7` : Add Spring Boot Data JPA package with H2 in-memory database
* `#8` : Add fare entity model and the repository for fares microservice using JPA
* `#9` : Add services, one to query from the repository, one to generate mock data into the repository
* `#10`: Add controllers, one to handle requests to get a fare for a given flight, one to handle generating mock data and saving it into H2 database
* `#11`: Configure application properties for H2 database for both environments

### v0.0.1-SNAPSHOT (PREVIOUS RELEASE)

* Move Greeting service as a sub-module (an independent microservice) for Flyem Spring Boot project
* `#1` : Move current Greeting implementation as a sub-module, refactor and update class names
* `#2` : Update Dockerfile config accordingly (this project is not root anymore, it is a sub-module now)
* `#3` : Add a new build.gradle file for this sub-module in-line with root project's build.gradle file
* `#4` : Add a new deployment file for kubernetes for this sub-module
* `#5` : Add a separate README and CHANGELOG files for this microservice.
* `#6` : Add environments 'dev' and 'prod' for this microservice

## Feature

### (NEXT RELEASEs)

* Add CI/CD processes