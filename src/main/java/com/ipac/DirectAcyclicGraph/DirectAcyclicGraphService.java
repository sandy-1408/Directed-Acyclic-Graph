package com.ipac.DirectAcyclicGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * This class represents a service for managing and working with a Directed Acyclic Graph (DAG).
 * It allows adding edges between vertices and finding the longest path starting from a given vertex.
 */

public class DirectAcyclicGraphService {

    // Adjacency set representing the graph structure, where each vertex maps to a set of its neighbors

    private final Map<Vertex, Set<Vertex>> adjSet = new HashMap<>();

    // Cache to store the longest path length from each vertex to avoid redundant calculations

    private final Map<Vertex, Integer> cache = new HashMap<>();

    /**
     * Adds an edge to the graph. An edge connects two vertices, 'from' and 'to'.
     * A self-loop (edge from a vertex to itself) is not allowed and will be skipped.
     */

    public void addEdge(Edge edge) {
        if (edge.from.equals(edge.to)) {
            System.out.println("Self-loop detected! Skipping edge from " + edge.from + " to " + edge.to);
            return;
        }

        // If the 'from' vertex is not yet in the adjacency set, initialize its entry

        if (!adjSet.containsKey(edge.from)) {
            adjSet.put(edge.from, new HashSet<>());
        }

        // Add the 'to' vertex as a neighbor to the 'from' vertex
        adjSet.get(edge.from).add(edge.to);

        System.out.println("Edge added from Vertex " + edge.from.id + " to Vertex " + edge.to.id);
    }

    /**
     * Finds the longest path starting from the given vertex.
     * The method uses memoization to cache the results of previously calculated paths.
     */


    public int findLongestPath(Vertex vertex) {
        if (cache.containsKey(vertex)) {
            return cache.get(vertex);
        }

        int maxLength = 0;


        // If the vertex has neighbors, calculate the longest path by recursively exploring them

        if (adjSet.containsKey(vertex)) {
            for (Vertex neighbor : adjSet.get(vertex)) {
                int pathLength = 1 + findLongestPath(neighbor);
                maxLength = Math.max(maxLength, pathLength);
            }
        }

        cache.put(vertex, maxLength);

        return maxLength;
    }

}
