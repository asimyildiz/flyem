# flyem-fares
FlyEm "fares" functionality microservice implementation using Spring Boot

# links
See [changelog](./CHANGELOG.md) for current versions and feature plans.

# api gateway
'/fares/getFare' route is used to get fare data for a given flight\
'/mockfares/generatedummyfares' route to generate mock fares data into our repository\
'/fares/{id}' route with PUT request is used to update fare data in our repository

# usage
Spring Boot Web package is used to create REST api endpoints (port:8080)\
Spring Boot Actuator package is used to monitor health of the application (port:9090)\
Spring Boot Data JPA package is used to manage our repository\
Spring Boot AMQP package is used to manage messaging between microservices using RabbitMQ\
Spring Cloud Starter Config package is used to get configuration file from another Spring application which uses Spring Cloud Config Server package\
H2 in memory database is used to store data for our repository\
Gradle is being used as build automation tool

in order to test the services on local machine:
- We need to first start "configserver" application which manages the configuration files
- ./gradlew :configserver:bootRun (from root folder)
- Run : "bootRun" gradle task of application 
- ./gradlew :fares:bootRun  (from root folder)

We can access the services and actuators using these links:
- Create Mock Fares Data : curl 'http://localhost:8080/mockfares/generatedummyfares'
- Get Fare Data for a given flight : curl 'http://localhost:8080/fares/getFare?flightNumber=FM100&flightDate=01-09-22'
- Update Fare Data with id : curl -X 'PUT' 'http://localhost:8080/fares/1' -H 'accept: */*' -H 'Content-Type: application/json' -d '{"id": 1, "flightNumber": "FM100", "flightDate": "01-09-22", "amount": 225, "currency": "TRY"}'
- Swagger : http://localhost:8080/swagger-ui.html
- OpenAPI V3 Docs : http://localhost:8080/v3/api-docs
- Actuator : http://localhost:9090/actuator/health
- H2 Console to query database : http://localhost:8080/h2-console/

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

In order to build the docker file for fares microservice, we need to provide the current application version to docker build command and run these commands from the fares sub-project's folder:
- DOCKER_BUILDKIT=1 docker build -t flyem/service-fares ../ -f . --build-arg APPLICATION_VERSION=fares-0.0.4-SNAPSHOT
- docker run -p 8080:8080 -p 9090:9090 flyem/service-fares --name fares
- docker login -u ${username}
- docker tag flyem/service-fares asimyildiz/flyem:service-fares-0.0.4-SNAPSHOT
- docker push asimyildiz/flyem:service-fares-0.0.4-SNAPSHOT

# orchestration
Kubernetes is being used for orchestration.\
Please check the root project's [README](../README.md) file for detailed Kubernetes setup guide.

After minikube is starting to work and before we run our deployment file, we need to first pull our docker image.
- minikube image pull asimyildiz/flyem:service-fares:0.0.4-SNAPSHOT

Then we need to start our kubernetes instance and check if our instance is started to run:
- kubectl apply -f ../k8s/deployment-fares.yaml
- kubectl get all

Then we need to create an ssh tunnel to the service that we have created in Kubernetes
- kubectl port-forward svc/fares-svc 8080:8080 9090:9090

# CI/CD pipeline
CI/CD pipeline will be added later
