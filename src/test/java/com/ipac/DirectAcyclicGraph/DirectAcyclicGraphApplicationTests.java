package com.ipac.DirectAcyclicGraph;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DirectAcyclicGraphApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testEmptyGraph() {
		DirectAcyclicGraphService dag = new DirectAcyclicGraphService();
		Vertex v1 = new Vertex(1);

		assertEquals(0, dag.findLongestPath(v1), "Longest path in an empty graph should be 0");
	}

	@Test
	public void testSingleVertex() {
		DirectAcyclicGraphService dag = new DirectAcyclicGraphService();
		Vertex v1 = new Vertex(1);

		assertEquals(0, dag.findLongestPath(v1), "Longest path from a single vertex should be 0");
	}

	@Test
	public void testSingleEdge() {
		DirectAcyclicGraphService dag = new DirectAcyclicGraphService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);

		dag.addEdge(new Edge(v1, v2));

		assertEquals(1, dag.findLongestPath(v1), "Longest path from v1 to v2 should be 1");
	}

	@Test
	public void testMultipleEdges() {
		DirectAcyclicGraphService dag = new DirectAcyclicGraphService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);

		dag.addEdge(new Edge(v1, v2));
		dag.addEdge(new Edge(v2, v3));

		assertEquals(2, dag.findLongestPath(v1), "Longest path from v1 to v3 should be 2");
	}

	@Test
	public void testDisconnectedGraph() {
		DirectAcyclicGraphService dag = new DirectAcyclicGraphService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);

		dag.addEdge(new Edge(v1, v2));
		dag.addEdge(new Edge(v3, v4));

		assertEquals(1, dag.findLongestPath(v1), "Longest path from v1 should be 1");
		assertEquals(1, dag.findLongestPath(v3), "Longest path from v3 should be 1");
	}

	@Test
	public void testSelfLoopSkipped() {
		DirectAcyclicGraphService dag = new DirectAcyclicGraphService();
		Vertex v1 = new Vertex(1);

		dag.addEdge(new Edge(v1, v1));

		assertEquals(0, dag.findLongestPath(v1), "Self-loop should be skipped, so longest path should be 0");
	}

	@Test
	public void testLongerPathWithMultipleBranches() {
		DirectAcyclicGraphService dag = new DirectAcyclicGraphService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);

		dag.addEdge(new Edge(v1, v2));
		dag.addEdge(new Edge(v2, v3));
		dag.addEdge(new Edge(v1, v4));
		dag.addEdge(new Edge(v4, v5));

		assertEquals(2, dag.findLongestPath(v1), "Longest path from v1 should be 2");
	}


	@Test
	public void testLargeGraph() {
		DirectAcyclicGraphService dag = new DirectAcyclicGraphService();
		Vertex[] vertices = new Vertex[1000];

		// Initialize 1000 vertices
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vertex(i);
		}

		// Create edges between consecutive vertices

		for (int i = 0; i < vertices.length - 1; i++) {
			dag.addEdge(new Edge(vertices[i], vertices[i + 1]));
		}

		assertEquals(999, dag.findLongestPath(vertices[0]), "Longest path in a large linear DAG should be 999");
	}

	@Test
	public void testMultiplePathsSameLength() {
		DirectAcyclicGraphService dag = new DirectAcyclicGraphService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);

		dag.addEdge(new Edge(v1, v2));
		dag.addEdge(new Edge(v2, v4));
		dag.addEdge(new Edge(v1, v3));
		dag.addEdge(new Edge(v3, v4));

		assertEquals(2, dag.findLongestPath(v1), "Longest path from v1 should be 2, with multiple same-length options");
	}

}
