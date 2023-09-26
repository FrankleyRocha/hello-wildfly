This project was created from the archetype "wildfly-jakartaee-ear-archetype".

To deploy it:
Run the maven goals "install wildfly:deploy"

To undeploy it:
Run the maven goals "wildfly:undeploy"

==========================

DataSource:
This sample includes a "persistence.xml" file in the EJB project. This file defines
a persistence unit "hello-wildflyPersistenceUnit" which uses the JakartaEE default database.

In production environment, you should define a database in WildFly config and point to this database
in "persistence.xml".

If you don't use entity beans, you can delete "persistence.xml".
==========================

JSF:
The web application is prepared for JSF 4.0 by bundling an empty "faces-config.xml" in "src/main/webapp/WEB-INF".
In case you don't want to use JSF, simply delete this file and "src/main/webapp/beans.xml".
==========================

Testing:
This sample is prepared for running unit tests with the Arquillian framework.

The configuration can be found in "hello-wildfly/pom.xml":

Three profiles are defined:
-"default": no integration tests are executed.
-"arq-remote": you have to start a WildFly server on your machine. The tests are executed by deploying
 the application to this server.
 Here the "maven-failsafe-plugin" is enabled so that integration tests can be run.
 Run maven with these arguments: "clean verify -Parq-remote"
-"arq-managed": this requires the environment variable "JBOSS_HOME" to be set:
 The server found in this path is started and the tests are executed by deploying the application to this server.
 Instead of using this environment variable, you can also define the path in "arquillian.xml".
 Here the "maven-failsafe-plugin" is enabled so that integration tests can be run.
 Run maven with these arguments: "clean verify -Parq-managed"

The Arquillian test runner is configured with the file "src/test/resources/arquillian.xml"
(duplicated in EJB and WEB project, depending where your tests are placed).
The profile "arq-remote" uses the container qualifier "remote" in this file.
The profile "arq-managed" uses the container qualifier "managed" in this file.


Unit tests can be added to EJB project and/or to Web project.

The web project contains an integration test "SampleIT" which shows how to create the deployable EAR file using the ShrinkWrap API.
You can delete this test file if no tests are necessary.

Why integration tests instead of the "maven-surefire-plugin" testrunner?
The Arquillian test runner deploys the EAR file to the WildFly server and thus you have to build it yourself with the ShrinkWrap API.
The goal "verify" (which triggers the maven-surefire-plugin) is executed later in the maven build lifecyle than the "test" goal so that the target
artifacts ("hello-wildfly-ejb.jar" and "hello-wildfly-web.war") are already built. You can build
the final EAR by including those files. The "maven-surefire-plugin" is executed before the JAR/WAR files
are created, so those JAR/WAR files would have to be built in the "@Deployment" method, too.

#https://www.wildfly.org/

#https://github.com/wildfly/wildfly-archetypes/tree/main/wildfly-jakartaee-ear-archetype

# mvn archetype:generate -DgroupId=my.project.org -DartifactId=sample-jakartaee-ear-archetype -Dversion=1.0-SNAPSHOT -DarchetypeGroupId=org.wildfly.archetype -DarchetypeArtifactId=wildfly-jakartaee-ear-archetype -DarchetypeVersion=30.0.0.Final-SNAPSHOT

````XML
<!-- https://mvnrepository.com/artifact/org.wildfly.archetype/wildfly-jakartaee-ear-archetype -->
<dependency>
    <groupId>org.wildfly.archetype</groupId>
    <artifactId>wildfly-jakartaee-ear-archetype</artifactId>
    <version>29.0.1.Final</version>
</dependency>
````

````BASH
mvn archetype:generate \
	-DgroupId=com.francalino.frankley.hellowildfly \
	-DartifactId=hello-wildfly \
	-Dversion=1.0-SNAPSHOT \
	-DarchetypeGroupId=org.wildfly.archetype \
	-DarchetypeArtifactId=wildfly-jakartaee-ear-archetype \
	-DarchetypeVersion=29.0.1.Final
````