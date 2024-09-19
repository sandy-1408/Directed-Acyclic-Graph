package com.ipac.DirectAcyclicGraph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DirectAcyclicGraphApplication {

	public static void main(String[] args) {

		SpringApplication.run(DirectAcyclicGraphApplication.class, args);

		DirectAcyclicGraphService dag = new DirectAcyclicGraphService();

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        dag.addEdge(new Edge(v1, v2));
        dag.addEdge(new Edge(v2, v3));
        dag.addEdge(new Edge(v3, v4));
        dag.addEdge(new Edge(v1, v4));
        dag.addEdge(new Edge(v4, v5));

        System.out.println("Longest path from vertex 3: " + dag.findLongestPath(v3));
	}

}
