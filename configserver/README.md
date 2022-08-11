# flyem-configserver
FlyEm "configserver" is the application to manage FlyEm microservices configuration files from a github repo using Spring Cloud Config Server.

# spring cloud config server
The Spring Cloud Config server is an externalized configuration server in which applications and services can deposit, access, and manage all runtime configuration properties.\ 
The Spring Config server also supports version control of the configuration properties.

# why a config server
For FlyEm microservices all configuration parameters were read from a property file (application.properties) packaged inside the projects.\
This approach is good, since all properties are moved out of code to a property file.\
However, when microservices are moved from one environment to another, these properties need to undergo changes, which require an application re-build.\ 
This is violation of one of the Twelve-Factor application principles, which advocate one-time build and moving of the binaries across environments.

# setup
Configuration files are added into another github [repo](https://github.com/asimyildiz/flyem-config)\
This github repo is added as a git submodule into this project.\
All microservices point to a central server to get the required configuration parameters.\
The microservices then locally cache these parameters to improve performance.\ 
The Config server propagates the configuration state changes to all subscribed microservices so that the local cache's state can be updated with the latest changes.\
The Config server also uses profiles to resolve values specific to an environment.

# usage
Spring Cloud Config Server package is used to get configuration files from the repo (port:8888)\
Gradle is being used as build automation tool

in order to test the services on local machine:
- Run : "bootRun" gradle task of application 
- ./gradlew :configserver:bootRun  (from root folder)

We can access the services to get configuration files using these links:
- Fares Microservice Dev environment config : curl 'http://localhost:8888/fares/dev/master'
- Fares Microservice Prod environment config : curl 'http://localhost:8888/fares/prod/master'
- Search Microservice Dev environment config : curl 'http://localhost:8888/search/dev/master'
- Search Microservice Prod environment config : curl 'http://localhost:8888/search/prod/master'

# commands - gradle tasks
- "application/bootRun": gradle task to run the application
- "build/clean": gradle task to clean project build
- "build/build": gradle task to build the project
