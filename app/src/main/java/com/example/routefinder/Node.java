package com.example.routefinder;

import java.util.LinkedList;

public class Node implements Comparable<Node>{

    private TransportationType type;
    private int id;
    private double gScore;
    private double fScore;
    private double arrivalTime;
    private double departureTime;
    private double heuristic; // distance to target destination

    public enum TransportationType{
        BUS, PLANE
    }

    public Node(TransportationType type, double heuristic){
        setType(type);
        this.heuristic = heuristic;
        this.gScore = Double.MAX_VALUE;
        this.fScore = Double.MAX_VALUE;
        this.arrivalTime = Double.MAX_VALUE;
    }

    public int compareTo(Node other){
        return Double.compare(fScore, other.fScore);
    }

    public void setType(TransportationType type){
        this.type = type;
    }

    public TransportationType getType(){
        return type;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getgScore() {
        return gScore;
    }

    public void setgScore(double gScore) {
        this.gScore = gScore;
    }

    public double getfScore() {
        return fScore;
    }

    public void setfScore(double fScore) {
        this.fScore = fScore;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(double departureTime) {
        this.departureTime = departureTime;
    }
}
