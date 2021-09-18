package com.coalcellar.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Graph {
    int[] dist;
    Set<Integer> visited;
    PriorityQueue<Node> priorityQueue;
    List<List<Node>> adjacencyList;
    int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        dist = new int[vertices];
        visited = new HashSet<>();
        priorityQueue = new PriorityQueue<>(vertices, Comparator.comparingInt(o -> o.cost));
    }

    public void dijkstra(List<List<Node>> adjacencyList, int vertex) {
        this.adjacencyList = adjacencyList;
        // distance 는 최대값으로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // start 의 값부터 일단 삽입.
        priorityQueue.add(new Node(vertex, 0));

        // start -> start 는 0이므로
        dist[vertex] = 0;

        while (visited.size() != vertices) {

            int current = priorityQueue.remove().node;
            visited.add(current);

            for (int i = 0; i < adjacencyList.get(current).size(); i++) {
                Node adjacency = adjacencyList.get(current).get(i);

                if (!visited.contains(adjacency.node)) {
                    int edgeDistance = adjacency.cost;
                    int newDistance = dist[current] + edgeDistance;

                    if (newDistance < dist[adjacency.node])
                        dist[adjacency.node] = newDistance;

                    priorityQueue.add(new Node(adjacency.node, dist[adjacency.node]));
                }
            }
        }
        log.info("priorityQueue empty : {}", priorityQueue.isEmpty());
    }
}
