## This project is about the spring boot, the latest buzz in the spring community.

WARNING:
=
1. DO NOT TRY TO DEPLOY A SPRING BOOT APPLICATION ON GOOGLE CLOUD PLATFORM - IT IS VERY COMPLICATED, BUGGY AND IN BETA. TRY HEROKU, CLOUD FOUNDRY OR OPENSHIFT

##Issues

1. Fix the security issues
1. Fix the problems with the swagger documentation: 
    1. security 
    1. return code is not the correct one.
1. The same application context for embedded and deployed application. 


####What I would like to use in this project (which I would like to consider the starting point for any technical assignment;) 
TODOs:
-
1. [V] Deploy the spring boot application in a tomcat container hosted by a docker container.
    Issues:
    1. Use different maven profiles for embedded tomcat(default) and deployed war in a docker tomcat container.
    1. The actuator endpoints don't work
    1. The security is messed.
1. Refactor the project as a multi module maven - REST API, WEB application.
1.[V] Spring cache (JSR-107 - JCache, ehcache|Hazelcast)
1.[>] Include the spring integration
    1. [V] Configuration with spring boot 
    1. [V] simple example
    1. get a file content, do some transformation and then save them back in another file.
    1. get a file content, split each line using a splitter, and save the information in db
1. Spring Batch
    1. configuration
    1. simple example
1. Try to integrate swagger as REST services documentation.
1. [OPT] Test the cache
1. Simple example with the Spring HATEOAS to create correct REST services.
1. Validation (JSR-303)
1. i18n
    1. spring boot thymeleaf pages
    1. SPA AngularJS
1. deploy the jar to github and make it the dependency of another project
1. integration tests - failsafe maven plugin

1. KPIs - Key performance indicator - 
    http://www.pnmsoft.com/resources/bpm-tutorial/key-performance-indicators/
    
    

1. [V] Simple Spring rest example
1. [V] Simple Spring MVC example.
1. [V] Integrate Spring Data JPA into the project.
1. [V] Integrate Spring data rest into the project.
1. [V] Spring webmvc with Thymeleaf (template engine - html)
1. [V] A simple example to expose a custom Data JPA method using Data Rest 
1. [V] Use yaml application config file instead of properties one. 
1. [V] Use two profiles: 
    1. production:  mysql datasource
    2. dev:         h2 datasource
1. [V] Custom JSON serialization to include both name and id, and to exclude properties with null value from the json.
1. Using AngularJS on the client side
    1. [V] Simple AngularJS application
    1. [V] Use AngularJS with REST services ($http injection)
    1. Use AngularJS with the REST resources ($resource)
1. [V] Include api in the built url of the REST services (done using the server.context-path application configuration)
        
        Instead of:
            http://localhost:8080/customers
        should have
            http://localhost:8080/api/customers
1. [>] Twitter bootstrap - support provided by webjars
1. Integration of spring security
    1. [V] for classic web application (spring webmvc with thymeleaf)
    1. for SPA with AngularJS
    1. using a OAuth2
    1. use @PreAuthorize("hasRole(@roles.ADMIN)") for services and data repositories
    1. single sign on with FB, Google, Linkedin, Twitter
    1. Handle csrf and remove the csrf().disable() in spring security configuration.
    1. Security with spring data jpa model
        https://github.com/spring-projects/spring-data-examples/tree/master/rest/security
1. Files uploading. Blob, REST, Data REST, AngularJS/Thymeleaf
1. Binding: JPA model - MVC data model
1. Messaging AMQP
1. Logstash, Kibana, ElasticSearch (logging)
1. Install the spring boot based application in Cloud Foundry, Heroku (GCP (Google Cloud Platform)).
1. Load balancing - install the application in many nodes and balance the calls between them
1. Spring Session - see what it is all about.
1. Spring Couchbase
1. Spring Cassandra
1. Configure the ssl for tomcat and use https for all services
1. Scheduling example
1. Spring integration example
1. Simple example with websockets
1. Security with stormpath 
        https://docs.stormpath.com/java/spring-boot-web/index.html
1. Try to use scala, and see how the IntelliJ Idea handle it. If there is no support for this mix then drop it and stay with java8
1. Try to use spring-boot-devtools and chrome LiveReload extensions for speeding up the ui development.
1. Try to use the spring-loaded for hot swapping 

Notes:
-
1. Exposing JPA repositories (which means CRUD operations of the JPA entities is just the matter of including the following maven dependency.
1. I am very impressed of the degree REST services are exposed by spring data rest, w/o writing a single line of code. IMPRESSIVE!!!
1. In order to quick and easily test the REST services, benefiting from the calls history, user friendly interface and saving the rest command as HTTP, curl calls, use the **__POSTMAN__** chrome extension.


How to run:
-
1. Install java 8
1. Install mvn 3
1. [optional - in case of profiles.active=prod] Install the mysql server
1. [optional - in case of profiles.active=prod] Create the following env variables: 
        
        MYSQL_DB
        MYSQL_USERNAME
        MYSQL_PASSWORD 
1. [optional - in case of profiles.active=prod] Execute the sql script db/db.sql
1. [optional - in case of profiles.active=prod]  Restart the IDE in order to access the newly created variables. Start the application as a Spring boot, or
1. using maven: mvn clean install spring-boot:run

How to test:
-
In case of the dev environment the embedded h2 database is used. To see the db data do the followings:
* open the http://localhost:8080/console
* use the following connection info
    * driver:       org.h2.Driver
    * url:          jdbc:h2:mem:myDb
    * username:     sa
    * password: 
1. Access the application using the following urls
    
        http://localhost:8080/customers.rest
        http://localhost:8080/customers.do
1. Using the REST endpoints (created by spring jpa data):
        
        http://localhost:8080/customers
        http://localhost:8080/customers/{id}
1. For all the other repository (customers) endpoints exposed by Spring Data REST search in the console after 
    
        o.s.d.r.w.RepositoryRestHandlerMapping
        and
        /{repository}        
1. For instance if one want to create a new customer, he/she has to curl the following 

        curl -v -X POST -H "Content-Type: application/json" -d '{"name": "Magdalena Jipa"}' "http://localhost:8080/customers"
1. If he/she wants to modify one, execute the following curl command:

        curl  -v -X PUT -H "Content-Type: application/json" -d '{"name": "Magdalena Pazargic"}' "http://localhost:8080/customers/11"
1. Delete a customer
    
        curl -v -X DELETE "http://localhost:8080/customers/7"
1. search using a custom findBy... method in the CustomerRepository
    
        curl -X GET -v "http://localhost:8080/customers/search/byName?name=Antonel%20Pazargic"
1. search by customer id
        
        curl -v -X GET "http://localhost:8080/customers/search/byId?id=1"
    
1. point the browser to ***http://localhost:8080/index.html*** to see the AngularJS integration with spring boot web app.            
       
       
Questions
=
1. what is a clickjacking attack
    In spring security by default X-Frame-Options is set to denied, to prevent clickjacking attacks.
    In order to allow it
1. What is JHipster all about? http://jhipster.github.io/ 
1. Should I consider JHipster and Heroku for Spring Boot / AngularJS / Bootstrap / Npm / Gulp / Yeoman application? 
    