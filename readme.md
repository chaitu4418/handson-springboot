### This project is about the spring boot, the latest buzz in the spring community.

######What I would like to use in this project (which I would like to consider the starting point for any technical assignment;) 
###### TODOs:
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
1. Custom JSON serialization to include both name and id
1. Include api in the built url of the REST services
        
        Instead of:
            http://localhost:8080/customers
        should have
            http://localhost:8080/api/customers
1. Validation (JSR-303)
1. Binding: JPA model - MVC data model
1. Twitter bootstrap - support provided by webjars
1. Using AngularJS on the client side
1. Spring Couchbase
1. Spring Cassandra
1. Spring cache (JSR-107 JCache, Hazelcast)
1. Messaging AMQP
1. Logstash, Kibana, ElasticSearch (logging)
1. Install the spring boot based application in GCP (Google Cloud Platform)
1. Load balancing - install the application in many nodes and balance the calls between them
1. Spring Session - see what it is all about.
1. Configure the ssl for tomcat and use https for all services
1. Simple authentication example
1. Simple authorization example
1. Try to use spring-boot-devtools and chrome LiveReload extensions for speeding up the ui development.
1. Try to use the spring-loaded for hot swapping 

######Notes:
1. Exposing JPA repositories (which means CRUD operations of the JPA entities is just the matter of including the following maven dependency.
1. I am impressed how much RESTful services are exposed by spring data rest, w/o writing a single line of code. IMPRESSIVE!!!
1. In order to quick and easily test the REST services, benefiting from the calls history, user friendly interface and saving the rest command as HTTP, curl calls, use the **__POSTMAN__** chrome extension.


###### How to run:
1. Install java 8
1. Install mvn 3
1. Install the mysql server
1. Create the following env variables: 
        
        MYSQL_DB
        MYSQL_USERNAME
        MYSQL_PASSWORD 
1. Execute the sql script db/db.sql
1. Restart the IDE in order to access the newly created variables. Start the application as a Spring boot, or
1. using maven: mvn clean install spring-boot:run
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
    
            
       