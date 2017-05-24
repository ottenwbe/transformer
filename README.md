# transformer
[![Build Status](https://travis-ci.org/ottenwbe/transformer.svg?branch=master)](https://travis-ci.org/ottenwbe/transformer)

Transformer is a simple web service to convert data from one format to another.
For instance, you can convert a json document to yaml.

Transformer offers a UI and a REST API for the supported conversions. 

## Usage

Either run transformer with Gradle, or build the web service and then run it.

 ### Simply Run the app with Gradle

You can simply run the web service by starting it with [Gradle](https://gradle.org/). 
 
    ./gradlew bootRun                        

You can then access the UI by navigating to the following URL in your web browser.
 
    http://localhost:8080/
 

### Building an Executable Jar 

[Gradle](https://gradle.org/) is used to build the transformer app.  
 
    ./gradlew build
    
You can now run the application:
   
    java -jar build/libs/transformer-<current version>.jar 
 
Again the web UI can be accessed:

    http://localhost:8080/
 
 
## Supported conversions 

The conversions can also be triggered by calling the web service via the following paths:

|  From\To          | Json          | Yaml           | XML  |
| :-------------:    | :-------------: |:-------------:| :-----:|
| Json              | /json/to-json | /json/to-yaml | /json/to-xml |
| Yaml              | /yaml/to-json | /yaml/to-yaml | /yaml/to-xml |
| XML               | /xml/to-json | /xml/to-yaml | /xml/to-xml |

Example:

    curl localhost:8080/json/to-yaml -X POST -d '{"a":"b"}' -H "Content-Type: application/json"