package com.example.routefinder;

public class Edge {

    private Node source;
    private Node destination;
    private double startTime;
    private double endTime;
    private double cost;

    public Edge(Node source, Node destination, double startTime, double endTime, double cost){
        this.source = source;
        this.destination = destination;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
    }

    public double getWeight(double sliderInput){ // sliderInput is a double from 0 to 1
        double costScale = 2 * sliderInput;
        double timeScale = 2 *(1 - sliderInput);
        return (endTime - startTime) * timeScale * Constants.Edge.TIME_WEIGHT_SCALE + cost * costScale * Constants.Edge.COST_WEIGHT_SCALE;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public double getCost() {
        return cost;
    }
}
