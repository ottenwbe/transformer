# transformer
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Build Status](https://travis-ci.org/ottenwbe/transformer.svg?branch=master)](https://travis-ci.org/ottenwbe/transformer)
[![codecov](https://codecov.io/gh/ottenwbe/transformer/branch/master/graph/badge.svg)](https://codecov.io/gh/ottenwbe/transformer)
[![Known Vulnerabilities](https://snyk.io/test/github/ottenwbe/transformer/badge.svg)](https://snyk.io/test/github/ottenwbe/transformer)

Transformer is a simple web service to convert data from one format to another.
For instance, you can convert a json document to yaml.

Transformer offers an UI and a REST API for all conversions from and to Json, Yaml, and XML. 

## Use-Case

Transformer is an example of a stateless web service written in Java with Spring Boot. 
It was initially developed to experiment with data serialization libraries. 
However, it then evolved to a test application for cloud~ish deployments.

## Usage

Transformer is available as docker image.

    docker pull ottenwbe/transformer:latest

To start transformer execute:
 
    docker run -d -p 8080:8080 ottenwbe/transformer:latest

### Using the UI

You can access the UI by navigating to the following URL in your web browser.

    http://localhost:8080/

### Using REST

The conversions can be triggered by calling the web service via REST:

|  From\To          | Json          | Yaml           | XML  |
| :-------------:   | :-------------: |:-------------:| :-----:|
| Json              | /json/to-json | /json/to-yaml | /json/to-xml |
| Yaml              | /yaml/to-json | /yaml/to-yaml | /yaml/to-xml |
| XML               | /xml/to-json  | /xml/to-yaml  | /xml/to-xml |

Example:

    curl localhost:8080/json/to-yaml -X POST -d '{"a":"b"}' -H "Content-Type: application/json"
    
## Development

### Get Started  

1. Clone the git repo

    ```
    git clone https://github.com/ottenwbe/transformer.git
    ```

1. You can then simply run the web service to see if everything is in order.
    ``` 
    ./gradlew bootRun
    ```      

### Build an Executable Jar 

 [Gradle](https://gradle.org/) is used to build transformer.  
 
    ./gradlew build
    
You can now run the application:
       
    java -jar build/libs/transformer-$(./gradlew -q printVersion).jar 

### Tests

    ./gradlew test

### Build Docker Images

All Dockerfiles can be found under ``packaging/container/``.

x86_64:

    docker build --build-arg JAR_FILE=transformer-$(./gradlew -q printVersion).jar -f packaging/container/x86_64/Dockerfile -t ottenwbe/transformer:latest .
    
armhf:
    
    docker build --build-arg JAR_FILE=transformer-$(./gradlew -q printVersion).jar -f packaging/container/armhf/Dockerfile -t ottenwbe/transformer:latest .

To start the container execute:
 
    docker run -d -p 8080:8080 ottenwbe/transformer:latest
    
## Deployments

### Kubernetes

All files needed to deploy the app on kubernetes can be found in the ``deployment/kubernetes`` folder.

    kubectl apply -f deployment/kubernetes/x86_64/deploy.yaml 

## Planned Additions
* HELM Chart
* CF Manifest