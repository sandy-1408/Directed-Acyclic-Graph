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

Code Overview:

An adjacency list is used to model the graph. Every vertex in this list functions as a key in a map, and the list of vertices that each key vertex directly connects to is the corresponding value. The connections and interconnections between the vertices are well captured by this structure.

Memorization is used to increase productivity and reduce the need for unnecessary calculations. This method entails storing the outcomes of previously calculated longest paths in a Map<Vertex, Integer>. This computes the longest path for each vertex only once, allowing subsequent queries for that vertex to be promptly addressed by retrieving the cached value.

The findLongestPath method uses DFS to search every path that could possibly lead from a given vertex. The DFS optimizes the algorithm's overall performance by using the longest path from a vertex that has already been computed and stored in the longestPathMap, rather than recalculating it.

In the base case, a vertex in the graph is a terminal vertex since it has no outgoing edges. Since there are no more vertices to go through, the longest path that starts at one of these vertices is zero.

Large graphs, disconnected components, and self-loops are among the cases that the implementation takes into consideration. Every instance is managed to guarantee the precision and effectiveness of the longest path calculation.

The technique can handle both tiny networks and bigger datasets with thousands of vertices because it is built to scale effectively. Memorization prevents unnecessary computations, ensuring that performance is optimal even with growing complexity.



1. Does the solution work for larger graphs?
   Yes, the method functions well for larger graphs. however, because of the recursive nature of the approach, its efficiency may suffer with very large graphs. Memorization reduces the need for redundant calculations, which makes it more effective than a naive method.
   
2. Can you think of any optimizations?
   Iterative technique: To prevent deep recursion, which may be advantageous for very large graphs, use an iterative technique combined with a topological sort.
Enhanced Memorization: To speed up lookups and updates, handle the cache using more effective data structures or algorithms.

3. What’s the computational complexity of your solution?
   The number of vertices (V) and edges (E) in the solution determine its time complexity, which is O(V + E). As a result, every vertex and edge was visited once. O(V + E) is the space complexity as well because of the adjacency set and cache storage.

4. Are there any unusual cases that aren't handled?
The algorithm considers the graph to be a legitimate DAG. Since this technique is meant to operate on acyclic graphs, it would not function properly if the graph included cycles. Furthermore, it is predicated on the graph being connected from the initial vertex.
Graphs without any outgoing edges from the beginning vertex are examples of common edge situations that this effective approach can manage.

Explanation of Tests:

testEmptyGraph: Tests the case of an empty graph where no vertices or edges exist.

testSingleVertex: Tests a graph with only a single vertex and no edges.

testSingleEdge: Tests a simple graph with one edge between two vertices.

testMultipleEdges: Tests a small graph with a sequence of connected edges.

testDisconnectedGraph: Tests a graph with two disconnected components.

testSelfLoopSkipped: Tests the scenario where a self-loop is attempted but should be skipped.

testLongerPathWithMultipleBranches: Tests a DAG with multiple possible paths from the same starting vertex.

testGraphWithCycleAvoidance: Tests a DAG setup that could resemble a cycle but ensures only valid DAG paths are calculated.

testLargeGraph: Tests a large graph with a simple linear structure.

testMultiplePathsSameLength: Tests a DAG with multiple paths of the same length.


 
