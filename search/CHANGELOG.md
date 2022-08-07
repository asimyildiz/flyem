# CHANGELOG

## History
### v0.0.1-SNAPSHOT (CURRENT RELEASE)

* Implement Search microservice for Flyem Spring Boot project
* `#1` : Add Spring Boot Data JPA package with H2 in-memory database (to manage a slave copy)
* `#2` : Add fare entity model to manage Fare data (same entity model of fares service, to manage fares)
* `#3` : Add inventory entity model to manage Inventory data (will be a base model for an inventory data, will be managed by booking)
* `#4` : Add flight entity model to manage Flight data and the repository for search microservice using JPA
* `#5` : Add services, one to query from the flight repository, one to generate mock data into the repository, one to update inventory and one to update fares
* `#6` : Add Spring Boot AMQP (Advanced Messaging Queuing Protocol) package, implement RabbitMQ receiver
* `#7` : Add controllers, one to handle requests to search for a flight, one to handle generating mock data and saving it into H2 database
* `#8` : Configure application properties for H2 database for both environments

## Feature

### (NEXT RELEASEs)

* Add CI/CD processes