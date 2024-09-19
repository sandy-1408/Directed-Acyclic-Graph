# Summary


This Java Spring Boot application finds the longest directed path in a directed acyclic graph (DAG) beginning at a given vertex. Graph theory, specifically topological sorting, is utilized in the solution to effectively determine the longest path. To verify the accuracy of the implementation, JUnit 5 unit tests are also included in the project.

## Required 
* Java 17 or later is needed in order for the program to compile and run.
* Maven 3.6.0 or later: To build the project and manage dependencies.
* The framework used to develop and run the application is Spring Boot 3.0.0 or later.

## Project Organization
* DirectAcyclicGraphService: The main function in charge of determining the longest path and adding edges.
* Vertex: Symbolizes a vertex within a graph.
* An edge is a directed edge that connects two vertices.
* DirectAcyclicGraphApplication: The Spring Boot application's entry point.


## Build Instruction
To build the project, use Maven:




    `mvn clean install`

After cleaning up previous builds, the application is compiled, tested, packaged, and installed into the local Maven repository.


## Running the Application
After building, we can run the Spring Boot application with:

    `mvn spring-boot:run`

The Spring Boot application is launched by running it straight from the source code.


# Running the  Unit Tests
JUnit 5 is used for unit testing. We can run the tests using Maven:

    `mvn test`

The project's unit tests are executed using Maven.
