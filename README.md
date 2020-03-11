# Rest Services Api

#### Rest APIs exposed to be invoked from PHP.

## Build

* Compile and execute tests (Unit Tests)
    
        mvn test

* Compile and execute tests (Unit Tests and Integration Tests)
    
        mvn verify
    
* To deploy the application to GCP App Engine
    
        mvn clean verify appengine:deploy -Pcloud-gcp
        
#### Google GCP Project Id

        For this project, i have created a new GCP project with name 'personal-pet-project'
    
#### Helpful Links

    https://github.com/GoogleCloudPlatform/getting-started-java/tree/master/appengine-standard-java8/springboot-appengine-standard
        
#### Ports

    application port => 1443
    actuator port => 8443

### API Endpoints
    
    GET /manage/health      ( Uses Actuator Port )
    GET /hello
    GET /hello/{anyString}
    
    GET /products/{productId} Ex: /products/1234 , /products/6789
    POST /products

#### API documentation url ( Uses Application Port )
    
    Swagger UI => http://localhost:18000/api-docs
    As Json    => http://localhost:18000/api-docs.json  