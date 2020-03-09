# Rest Services Api

#### Rest APIs exposed to be invoked from PHP.

## Build

* Compile and execute tests (Unit Tests)
    
        mvn test

* Compile and execute tests (Unit Tests & Integration Tests)
    
        mvn verify -Pdev
    
* Run only the integration tests
    
        mvn verify -DskipTests=true -Pdev

* To build the FAT jar, run all the tests ad build a Docker image in your local Docker registry
    
        mvn verify -Pdev
    
## E2E for Docker compose

* To spin up a docker container for the service

        mvn verify -Pdev,e2e
    
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
     
### Run the docker container locally
    
   ##### Pre-requisites:
          Docker Service installed locally.

   ##### Please follow the below steps to run the docker container locally.
   
         docker pull partech/rest-services-api
    
         docker run -d -p 1443:1443 -p 8443:8443 partech/rest-services-api
   
   ##### API Endpoints locally
       
       GET http://localhost:8443/manage/health      ( Uses Actuator Port )
       GET http://localhost:1443/hello
       GET http://localhost:1443/hello/{anyString}
       
       GET http://localhost:1443/products/{productId} [ Ex: /products/1234 , /products/6789 ]
       POST http://localhost:1443/products    [ Product Json ]
       
   ##### Open Api Specification
   
       We can test all the endpoints from the below Url.
        
       http://localhost:1443/api-docs  