package com.example.routefinder;

import java.util.ArrayList;

public class Route {

    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    private double time;
    private double cost;

    public Route(ArrayList<Node> nodes, ArrayList<Edge> edges, double time, double cost){
        this.nodes = nodes;
        this.edges = edges;
        this.time = time;
        this.cost = cost;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public double getTime() {
        return time;
    }

    public double getCost() {
        return cost;
    }
}
