package com.example.routefinder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DirectedWeightedGraph {

    private int vertices;
    private ArrayList<Node> nodes;
    private LinkedList<Edge>[] adjacencyList;

    public DirectedWeightedGraph(ArrayList<Node> nodes){
        this.nodes = nodes;
        this.vertices = nodes.size();
        for(int id = 0; id < vertices; id++){
            nodes.get(id).setId(id);
        }
        adjacencyList = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(Node source, Node destination, double startTime, double endTime, double cost){
        Edge edge = new Edge(source, destination, startTime, endTime, cost);
        adjacencyList[source.getId()].addFirst(edge);
    }

    public LinkedList<Edge> getEdges(Node node){
        return adjacencyList[node.getId()];
    }

    public Edge getEdge(Node source, Node destination){
        LinkedList<Edge> list = adjacencyList[source.getId()];
        return list.get(list.indexOf(destination));
    }

}
