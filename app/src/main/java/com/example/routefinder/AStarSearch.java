package com.example.routefinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AStarSearch {

    private double sliderInput;
    private DirectedWeightedGraph graph;
    private Node source;
    private Node destination;

    public AStarSearch(DirectedWeightedGraph graph, Node source, Node destination){
        this.graph = graph;
        this.source = source;
        this.destination = destination;
    }

    public void setSliderInput(double sliderInput) {
        this.sliderInput = sliderInput;
    }

    public Route search(){
        HashSet<Node> evaluated = new HashSet<>();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(source);
        HashMap<Node, Node> cameFrom = new HashMap<>();
        source.setgScore(0);
        source.setfScore(source.getHeuristic());
        source.setArrivalTime(0);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current == destination){
                return reconstruct_path(cameFrom, current);
            }
            evaluated.add(current);
            LinkedList<Edge> edges = graph.getEdges(current);
            for(Edge edge : edges){
                if(edge.getStartTime() < current.getArrivalTime()) continue;
                Node neighbor = edge.getDestination();
                if(evaluated.contains(neighbor)) continue;
                double tentativeGScore = current.getgScore() + edge.getWeight(sliderInput); // TODO: put actual slider value
                if(!queue.contains(neighbor)) queue.add(neighbor);
                else if(tentativeGScore >= neighbor.getgScore()) continue;
                cameFrom.put(neighbor, current);
                neighbor.setgScore(tentativeGScore);
                neighbor.setfScore(neighbor.getgScore() + neighbor.getHeuristic());
                current.setDepartureTime(edge.getStartTime());
                neighbor.setArrivalTime(edge.getEndTime());
            }
        }
        return null; // shouldn't happen
    }

    public Route reconstruct_path(HashMap<Node, Node> cameFrom, Node current){
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        nodes.add(current);
        double cost = 0;
        double endTime = current.getArrivalTime();
        while(cameFrom.containsKey(current)){
            Node previous = cameFrom.get(current);
            Edge edge = graph.getEdge(previous, current);
            edges.add(edge);
            cost += edge.getCost();
            current = previous;
            nodes.add(current);
        }
        Collections.reverse(edges);
        double totalTime = endTime - current.getDepartureTime();
        return new Route(nodes, edges, totalTime, cost);
    }

}
