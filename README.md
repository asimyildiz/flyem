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

# containerization
Docker is being used for containerization
Spring Boot's fat JAR which includes all the layers is extracted to divide external and internal dependencies.
It has 3 layers. All the application resources fit into two layers. 
If the application dependencies do not change, the first layer (from BOOT-INF/lib) need not change, so the build is faster and the startup of the container at runtime if also faster, as long as the base layers are already cached. 
In order to build the docker file, you need to provide the current application version to docker build command which will be automated with CI/CD pipeline integration later on:
- DOCKER_BUILDKIT=1 docker build -t com/flyem . --build-arg APPLICATION_VERSION=service-0.0.3-SNAPSHOT
- docker run -p 8080:8080 -p 9090:9090 com/flyem --name flyem

# orchestration
Kubernetes will be added as orchestrator later

# CI/CD pipeline
CI/CD pipeline will be added later
