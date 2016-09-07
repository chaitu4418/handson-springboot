### This project is about the spring boot, the latest buzz in the spring community.

######What I would like to use in this project (which I would like to consider the starting point for any technical assignment;) 
###### TODOs:
1. [V] Simple Spring rest example
1. [V] Simple Spring MVC example.
1. [V] Integrate Spring Data JPA into the project.
1. Integrate Spring data rest into the project.
1. Spring Couchbase
1. Spring Cassandra
1. Spring webmvc with Thymeleaf (template engine - html)
1. Spring cache (JSR-107 JCache, Hazelcast)
1. Validation (JSR-303)
1. Messaging AMQP
1. Logstash, Kibana, ElasticSearch (logging)
1. Using AngularJS on the clien side

######Notes:
1. After I've been reading about it and seeing some presentations I came to the conclusion spring boot is a great project and is likely to make the life of the java enterprise developer a lot easier (more time for the family).
1. It is based on maven (but probably, if I consider I am familiar enough with gradle, I will use gradle instead)
1. I know the packaging should be grouped based on functionality rather than the frameworks/architecture related stuff. But, until I have a good business model I'll go with the frameworks/arch based one.

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
    
        http://localhost:8080/customers
        http://localhost:8080/customers.php

