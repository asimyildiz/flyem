# flyem
FlyEm service implementation using Spring Boot which consists of sub-projects as independent, loosely-coupled microservices for FlyEm airline company.\
All microservices here uses Java-Spring Boot technology but they are being developed, tested, packaged, containerized, deployed, run and orchestrated (scaled) independently.\
All microservices here can be exported to different repositories easily.\
Gradle sub-projects are used here to maintain our microservices from single repository.

# links
See [changelog](./CHANGELOG.md) for general information about the services and feature plans.\
See [fares-changelog](./fares/CHANGELOG.md) for fares microservice current version and feature plans.\
See [search-changelog](./search/CHANGELOG.md) for search microservice current version and feature plans.

# sub-projects (microservices)
fares: fares microservice implementation\
search: search microservice implementation

# usage
Spring Boot Dependency Management package is used to manage dependencies and configuration automatically for all sub-packages.\
Spring Boot Dev Tools and Spring Boot Starter Test packages are being used for all sub-projects as default dependencies which will be used for development.\
Gradle is being used as build automation tool for the project and all sub-projects.

Sub-projects can be run directly from root project:
- Run : "bootRun" gradle task of application 
- ./gradlew (:fares:clean) :fares:bootRun
- ./gradlew (:search:clean) :search:bootRun

In order to run this demo effectively:
- We need to run RabbitMQ Server first (microservices depend on it)
- We don't need to but we can run Logstash, Elasticsearch and Kibana to check our logs
- First we can build both of our microservices and run tests
- Then we need to run both of our microservices (fares, search)
- Then we can check if our microservices are running correctly by checking their healths from actuators
- Then we need to generate some mock data for our fares microservice and for our search microservice
- Then we can check our fares microservice by sending requests from it's swaggerui
- Then we can check our search microservice by sending requests from it's swaggerui
- Then we can update a fare value using it's swaggerui and check if our message broker is running correctly by getting the flight request with this fare value from it's swaggerui
- We can also check if our logs are printed out to console and saved to logstash and can be queried from Kibana board (if ELK stack is up and running)

Then:
- We can test the same scenario above after dockerizing our microservices
- We can test the same scenario above with kubernetes and our docker images

# development packages
There are no default development packages used for all sub-projects by default, except Dev Tools and Starter Test packages.\
All microservices will decide if they are going to use packages like lombok, springdocs-openapi etc.

# messaging
Microservices are interacting (messaging) with other microservices using RabbitMQ that comes with AMQP package.\
In order to run RabbitMQ on our local machine, first we need to install it. On MacOS we can install it using brew.\
Then we need to add CLI tools and server scripts of RabbitMQ into path:
- export PATH=$PATH:/usr/local/sbin

Then we can run the RabbitMQ with:
- brew services start rabbitmq

# logging
Since we are going to implement a microservice which will eventually work together with other microservices 
as well as with many applications and other systems in a distributed system, we are going to integrate 
ELK (elasticsearch, logstash, kibana) stack, a useful tool for centralized log aggregation and analysis.

# elasticsearch
First we need to download elasticsearch client.\
We can disable the geoip layer while working on the local machine by updating "elasticsearch.yml" file under config folder:
- ingest.geoip.downloader.enabled: false

We do not need to change any other setting.\
We can start elasticsearch and check if it is running from a browser:
- ./bin/elasticsearch

We need to store the password for default "elastic" user from the console and enter it when we try to access elasticsearch web page:
- https://localhost:9200
- curl -X GET -u elastic:${password} https://localhost:9200/ -k

> You need to be sure that your cluster health status is not RED. For example if your password is not generated automatically on your first run because shards for security are not started correctly, you need to fix the problems and then delete the data folder and restart elasticsearch. High disk watermark [90%] can cause such problems where you need to free some space on your disk before you run elasticsearch. 

# kibana
First we need to download kibana client and we need to be sure that elasticsearch is running correctly as described above.\
We do not need to change any setting from "kibana.yml" file.\
We can start kibana and check if it is running from a browser:
- ./bin/kibana

We can generate a password for default kibana user "kibana_system" over elasticsearch:
- ./bin/elasticsearch-reset-password -u kibana_system --url https://localhost:9200

> If you have other network interfaces up, you need to provide --url option or else you will see a "No subject alternative names matching IP address" to one of your ip address of your interfaces and password reset command will not work.

We need to store the password for "kibana_system" user from the console.\
We need to navigate to the url printed out to the console to complete our setup (only on our first run). \
We can select to "Configure Manually" and set the ip address of elasticsearch client "https://localhost:9200". \
Then we need to enter the username(kibana_system) and password(copied password) when we try to access elasticsearch over kibana:
- http://localhost:5601/?code=XXXXXX

After everything is setup correctly, Kibana will add these login information into "kibana.yml" file so that we will not need to enter these every time.\
Then we can enter our "elastic" user's name and password to login to kibana dashboard.

# logstash
First we need to download the logstash client and we need to be sure that elasticsearch is running correctly as described above.\
We can generate a password for default logstash user "logstash_system" over elasticsearch.\
We can use the user "logstash_system" with it's password to configure logstash by updating "logstash.yml" file under config folder:
- ./bin/elasticsearch-reset-password -u logstash_system --url https://localhost:9200

We need to create a configuration (.conf) file inside the main folder of logstash with the name "logstash.conf".\
This configuration file consists of 3 components, "Input", "Filter", "Output".\
Input will be our log file generated by our Spring Boot Application.\
Filter will include what processing we want to apply to the data.\
Output will be our elasticsearch client.\
Please see the sample "logstash.conf" file under "sample-configs" folder.\
We can then start logstash using the command:
- ./bin/logstash -f logstash.conf

After logstash started working correctly, we can run the gradle task "bootRun" to start testing our ELK stack.\
We can just call our services where we integrate ELK stack and then check the logs from "logs/application.log" file.\
We can also see the logs from logstash and elasticsearch running instances from terminals.

# display logs from kibana
We need to first check if our logs are being correctly synced to our elasticsearch client:
- https://localhost:9200/_cat/indices

We need to then access our kibana dashboard from a browser and select "Kibana/Data Views" from left menu:
- http://localhost:5601/app/management/

We need to "Create data view" by giving it a name which needs to match with the sources on the right panel:
- logs-*

We can check our logs from this source now:
- http://localhost:5601/app/discover

# commands
The commands can vary from microservice to microservice.\
Please check all gradle tasks of sub-projects before you run a task.

# testing
You can run the tests by using the gradle task for every microservice:
> "verification/test"

Spring Boot Test package is being used for testing.\
Jupiter JUnit extension is being used for test execution.\
!Code Coverage will be measured and added later

# containerization
Docker is being used for containerization.\
Spring Boot's fat JAR which includes all the layers is extracted to divide external and internal dependencies.\
It has 3 layers. All the application resources fit into two layers.\
If the application dependencies do not change, the first layer (from BOOT-INF/lib) need not change, so the build is faster and the startup of the container at runtime if also faster, as long as the base layers are already cached.

Project's docker image is pushed to dockerhub. Kubernetes will pull the image from inside its Kubelets (nodes) via dockerhub.\
In order to push the image to docker hub, we need to create a dockerhub account.\
After creating the dockerhub account, we need to create a new repository there. Our repository is asimyildiz/flyem for this project.\
Then we need to login to dockerhub from a terminal with our username by entering our password before we push our images:
- docker login -u ${username}

# orchestration
Kubernetes is being used for orchestration.\
In order to work on local machine, minikube with kubectl is being used.\
First we must start minikube and wait it to start up:
- minikube start

After we start minikube, we can test it with kubectl:
- kubectl cluster-info

Kubernetes control plane is running at https://127.0.0.1:${randomPort} \
CoreDNS is running at https://127.0.0.1:${randomPort}/api/v1/namespaces/kube-system/services/kube-dns:dns/proxy

After minikube is starting to work and before we run our deployment file, we need to first pull our docker images for our microservices before we run:
- minikube image pull asimyildiz/flyem:service-microservicename-VERSION

Then we need to start our kubernetes instance and check if our instance is started to run:
- kubectl apply -f k8s/deployment-microservicename.yaml
- kubectl get all

Then we need to create an ssh tunnel to the service that we have created in Kubernetes
- kubectl port-forward svc/microservice-servicename 8080:8080 9090:9090

# CI/CD pipeline
CI/CD pipeline will be added later
