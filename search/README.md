# flyem-search
FlyEm "search" functionality microservice implementation using Spring Boot

# links
See [changelog](./CHANGELOG.md) for current versions and feature plans.

# api gateway
'/search/flights' route is used to search for flights\
'/mockflights/generatedummyflights' route to generate mock flights data into our repository

# usage
Spring Boot Web package is used to create REST api endpoints (port:8081)\
Spring Boot Actuator package is used to monitor health of the application (port:9091)\
Spring Boot AMQP package is used to manage messaging between microservices using RabbitMQ\
Spring Boot Data JPA package is used to manage our repository\
Spring Cloud Starter Config package is used to get configuration file from another Spring application which uses Spring Cloud Config Server package\
H2 in memory database is used to store data for our repository\
Gradle is being used as build automation tool

in order to test the services on local machine:
- We need to first start "configserver" application which manages the configuration files
- ./gradlew :configserver:bootRun (from root folder)
- Run : "bootRun" gradle task of application 
- ./gradlew :search:bootRun  (from root folder)

We can access the services and actuators using these links:
- Search : curl -X POST 'http://localhost:8081/search/flights' -H 'accept: */*' -H 'Content-Type: application/json' -d '{"origin": "LAX", "destination": "DXB", "flightDate": "01-09-22"}' 
- Create Mock Flights Data : curl 'http://localhost:8081/mockflights/generatedummyflights'
- Swagger : http://localhost:8081/swagger-ui.html
- OpenAPI V3 Docs : http://localhost:8081/v3/api-docs
- Actuator : http://localhost:9091/actuator/health
- H2 Console to query database : http://localhost:8081/h2-console/

# development packages
lombok is being used to minimize/remove the boilerplate code by using annotations\
javadoc is being used for documenting the code\
springdoc-openapi is being used to generate API documentation\
javax.persistence extension is being used to manage for persistence and ORM

# messaging
Microservices are sending and receiving messages with other microservices using RabbitMQ that comes with Spring AMQP package

# logging
Please check the root project's [README](../README.md) file for detailed ELK stack setup guide.

# commands - gradle tasks
- "application/bootRun": gradle task to run the application
- "build/clean": gradle task to clean project build
- "build/build": gradle task to build the project
- "openapi/generateOpenApiDocs": gradle task to generate open api docs
- "documentation/javadoc": gradle task to generate javadoc comments (generated under build/docs/javadoc folder)
- "verification/test": gradle task to run tests 

# testing
You can run the tests by using the gradle task:
> "verification/test"

Spring Boot Test package is being used for testing.\
Jupiter JUnit extension is being used for test execution.\
!Code Coverage will be measured and added later

# containerization
Docker is being used for containerization. The docker config file for each sub-project is set up independently.\
BootBuildImage gradle task is disabled because we want to manually configure docker to do some optimizations.\
Please check the root project's [README](../README.md) file for the Docker optimization that we have applied.\

> gradle binaries are located in root project's folder. So we need to correctly handle our docker builds for our sub-projects.

In order to build the docker file for search microservice, we need to provide the current application version to docker build command and run these commands from the search sub-project's folder:
- DOCKER_BUILDKIT=1 docker build -t flyem/service-search ../ -f . --build-arg APPLICATION_VERSION=search-0.0.2-SNAPSHOT
- docker run -p 8080:8080 -p 9090:9090 flyem/service-search --name search
- docker login -u ${username}
- docker tag flyem/service-search asimyildiz/flyem:service-search-0.0.2-SNAPSHOT
- docker push asimyildiz/flyem:service-search-0.0.2-SNAPSHOT

# orchestration
Kubernetes is being used for orchestration.\
Please check the root project's [README](../README.md) file for detailed Kubernetes setup guide.

After minikube is starting to work and before we run our deployment file, we need to first pull our docker image.
- minikube image pull asimyildiz/flyem:service-search:0.0.2-SNAPSHOT

Then we need to start our kubernetes instance and check if our instance is started to run:
- kubectl apply -f ../k8s/deployment-search.yaml
- kubectl get all

Then we need to create an ssh tunnel to the service that we have created in Kubernetes
- kubectl port-forward svc/search-svc 8081:8081 9091:9091

# CI/CD pipeline
CI/CD pipeline will be added later
