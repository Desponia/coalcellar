package com.coalcellar.graph;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class GraphTest {

    @Test
    public void test1() {

        int vertex = 6;
        int start = 0;
        List<List<Node>> adjacencyLists = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            adjacencyLists.add(new ArrayList<>());
        }

        adjacencyLists.get(0).add(new Node(1, 5));
        adjacencyLists.get(0).add(new Node(2, 3));
        adjacencyLists.get(0).add(new Node(3, 2));
        adjacencyLists.get(0).add(new Node(4, 3));
        adjacencyLists.get(0).add(new Node(5, 3));
        adjacencyLists.get(2).add(new Node(1, 2));
        adjacencyLists.get(2).add(new Node(3, 3));

        Graph graph = new Graph(vertex);
        graph.dijkstra(adjacencyLists, start);

        for (int i = 0; i < graph.dist.length; i++)
            System.out.println(start + " \t\t " + i + " \t\t " + graph.dist[i]);
    }

    @Test
    public void test2() {
        int vertex = 6;
        String start = "A";
        Map<String, List<Node2>> adjacency = new HashMap<>();
        List<String> vertexList = Arrays.asList("A", "B", "C", "D", "E", "F");
        List<Node2> list1 = new ArrayList<>();
        list1.add(new Node2("B", 2));
        list1.add(new Node2("C", 5));
        list1.add(new Node2("D", 3));
        adjacency.put("A", list1);
        List<Node2> list2 = new ArrayList<>();
        list2.add(new Node2("A", 2));
        list2.add(new Node2("C", 7));
        list2.add(new Node2("F", 10));
        adjacency.put("B", list2);
        List<Node2> list3 = new ArrayList<>();
        list3.add(new Node2("A", 5));
        list3.add(new Node2("B", 7));
        list3.add(new Node2("D", 1));
        list3.add(new Node2("E", 2));
        list3.add(new Node2("F", 5));
        adjacency.put("C", list3);
        List<Node2> list4 = new ArrayList<>();
        list4.add(new Node2("A", 3));
        list4.add(new Node2("C", 1));
        list4.add(new Node2("E", 7));
        adjacency.put("D", list4);
        List<Node2> list5 = new ArrayList<>();
        list5.add(new Node2("C", 2));
        list5.add(new Node2("D", 7));
        list5.add(new Node2("F", 2));
        adjacency.put("E", list5);
        List<Node2> list6 = new ArrayList<>();
        list6.add(new Node2("B", 10));
        list6.add(new Node2("C", 5));
        list6.add(new Node2("E", 2));
        adjacency.put("F", list6);

        Graph2 graph2 = new Graph2(vertex);
        graph2.dijkstra(vertexList, adjacency, start);

//        graph2.dist
//                .forEach((key, value) -> System.out.println(key + " ==== " + value));
//        System.out.println("graph2.visited : " + graph2.visited);
        assertEquals(graph2.dist.get("F"), 8);

        // TODO making graph
    }

}