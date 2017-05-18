# transformer
[![Build Status](https://travis-ci.org/ottenwbe/transformer.svg?branch=master)](https://travis-ci.org/ottenwbe/transformer)

Transformer is simple web service to convert data from one file format to another.

Transformer offers a UI and a REST API for the supported conversions. 

## Usage

Either build the web service and then run it, or run it with Gradle.

### Building an Executable Jar 

[Gradle](https://gradle.org/) is used to build the transformer app.  
 
    ./gradlew build
    
You can now run the application:
   
    java -jar build/libs/transformer-<current version>.jar 
 
### Simply Run

You can simply run the web service by starting it with Gradle. 
 
    ./gradlew bootRun                        

You can then access the web-service via an locally in your web browser.
 
    http://localhost:8080/
 
## Supported conversions 

|  From\To          | Json          | Yaml           | XML  |
| :-------------:    | :-------------: |:-------------:| :-----:|
| Json              | /json/to-json | /json/to-yaml | /json/to-xml |
| Yaml              | /yaml/to-json | /yaml/to-yaml | /yaml/to-xml |
| XML               | /xml/to-json | /xml/to-yaml | /xml/to-xml |

