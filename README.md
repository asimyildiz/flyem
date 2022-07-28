# flyem
FlyEm microservice implementation using Spring Boot

# links
See [changelog](./CHANGELOG.md) for current versions and feature plans.

# api gateway
'/greeting' route is used to handle a greeting request

# usage
Spring Boot Web package is used to create REST api endpoints (port:8080)
Spring Boot Actuator package is used to monitor health of the application (port:9090)
Gradle is being used as build automation tool

in order to test the services on local machine:
- Run : "bootRun" gradle task of application
- Swagger : http://localhost:8080/swagger-ui.html
- OpenAPI V3 Docs : http://localhost:8080/v3/api-docs
- Greeting Service : curl 'http://localhost:8080/greeting?name=ASIM'
- Actuator : http://localhost:9090/actuator/health

# development packages
lombok is being used to minimize/remove the boilerplate code by using annotations
javadoc is being used for documenting the code
springdoc-openapi is being used to generate API documentation

# commands
- "application/bootRun": gradle task to run the application
- "build/clean": gradle task to clean project build
- "build/build": gradle task to build the project
- "openapi/generateOpenApiDocs": gradle task to generate open api docs
- "documentation/javadoc": gradle task to generate javadoc comments (generated under build/docs/javadoc folder)
- "verification/test": gradle task to run tests 

# testing
You can run the tests by using the gradle task:
> "verification/test"

Spring Boot Test package is being used for testing.
Jupiter JUnit extension is being used for test execution.
!Code Coverage will be measured and added later

# deployment
Containerization will be added using Docker later
Kubernetes will be added as orchestrator later

# CI/CD pipeline
CI/CD pipeline will be added later
