package com.coalcellar.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Graph2 {
    Set<String> visited;
    Map<String, Integer> dist;
    PriorityQueue<Node2> priorityQueue;
    Map<String, List<Node2>> adjacencyList;
    int vertices;

    public Graph2(int vertices) {
        this.vertices = vertices;
        dist = new LinkedHashMap<>();
        visited = new LinkedHashSet<>();
        priorityQueue = new PriorityQueue<>(vertices, Comparator.comparing(o -> o.cost));
    }

    public void dijkstra(List<String> vertexList, Map<String, List<Node2>> adjacencyList, String vertex) {
        this.adjacencyList = adjacencyList;
        for (String s : vertexList) {
            dist.put(s, Integer.MAX_VALUE);
        }

        priorityQueue.add(new Node2(vertex, 0));
        dist.put(vertex, 0);

        while (visited.size() != vertices) {
            String current = priorityQueue.remove().node;
            visited.add(current);
            log.info("current : {}", current);
            for (int i = 0; i < adjacencyList.get(current).size(); i++) {
                Node2 adjacency = adjacencyList.get(current).get(i);
//                log.info("adjacency.node : {}, adjacency.cost: {}", adjacency.node, adjacency.cost);
                if (!visited.contains(adjacency.node)) {
                    int edgeDistance = adjacency.cost;
                    int newDistance = dist.get(current) + edgeDistance;

                    if (newDistance < dist.get(adjacency.node)) {
                        dist.remove(adjacency.node);
                        dist.put(adjacency.node, newDistance);
                    }

                    priorityQueue.add(new Node2(adjacency.node, dist.get(adjacency.node)));
                }
            }
        }
    }
}
