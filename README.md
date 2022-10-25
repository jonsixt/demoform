Demo of form handling and persisting data

-expects environment with maven (tested on 3.6.1) + running PostgreSQL (tested on version 15.0, any non absolutely obsolete version should be fine)

-set up DB with src/main/resources/sql/ddl_and_prefill_request_type.sql

-build and launch with: "mvn clean package" +  "java -jar  target/demoform-0.0.1-SNAPSHOT.jar"

-open http://localhost:8080/form in your browser
