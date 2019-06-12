# transformer
[![Build Status](https://travis-ci.org/ottenwbe/transformer.svg?branch=master)](https://travis-ci.org/ottenwbe/transformer)
[![Known Vulnerabilities](https://snyk.io/test/github/ottenwbe/transformer/badge.svg)](https://snyk.io/test/github/ottenwbe/transformer)

Transformer is a simple web service to convert data from one format to another.
For instance, you can convert a json document to yaml.

Transformer offers an UI and a REST API for the supported conversions. 

## Use-Case

Transformer is an example for a stateless web service written in Java with Spring Boot. It was initially implemented to be able to experiment with data serialization libraries. It then evolved to a test application for cloud deployments.

## Usage

Either run transformer with Gradle, or build the micro service and then run it.

 ### Quick Start

You can simply run the web service by starting it with [Gradle](https://gradle.org/). 
 
    ./gradlew bootRun                        
 

### Building an Executable Jar 

[Gradle](https://gradle.org/) is used to build transformer.  
 
    ./gradlew build
    
You can now run the application:
   
    java -jar build/libs/transformer-<current version>.jar 
 
## UI

You can then access the UI by navigating to the following URL in your web browser.
 
    http://localhost:8080/
 
 
## REST: Supported Conversions 

The conversions can also be triggered by calling the web service via REST:

|  From\To          | Json          | Yaml           | XML  |
| :-------------:   | :-------------: |:-------------:| :-----:|
| Json              | /json/to-json | /json/to-yaml | /json/to-xml |
| Yaml              | /yaml/to-json | /yaml/to-yaml | /yaml/to-xml |
| XML               | /xml/to-json  | /xml/to-yaml  | /xml/to-xml |

Example:

    curl localhost:8080/json/to-yaml -X POST -d '{"a":"b"}' -H "Content-Type: application/json"