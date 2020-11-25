package com.java.ds.graphs;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private int vertices;
    private List<Integer> adjacencyList[];

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    public  void addEdge(int sourceVertex, int destinationVertex) {
        adjacencyList[sourceVertex].add(destinationVertex); //Linkedlist add will add at end
    }

    public int getVertices() {
        return vertices;
    }

    public List<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }
}
