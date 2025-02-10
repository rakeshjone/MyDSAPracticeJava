package Graphs;

import LinkedListProbs.DoublyListWithTail;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    //Graph with internal linkedlist
    int vertices;
    LinkedList<Integer> list[];

    public Graph(int vertices) {
        this.vertices = vertices;
        list = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public int countEdges() {
        int edges = 0;
        for (LinkedList<Integer> l: list) {
            Iterator iterator = l.listIterator();
            while (iterator.hasNext()) {
                edges++;
                iterator.next();
            }
        }
        return edges/2;
    }

    public int countEdgesSimple() {
        int edges = 0;
        for (LinkedList<Integer> l:list) {
            edges += l.size();
        }
        return edges/2;
    }

    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.list[source].addLast(destination);
            //for undirect graph
            //this.list[destination].addLast(source);
        }
    }

    public void printGraph() {
        int i = 0;
        for (LinkedList<Integer> a: list) {
            System.out.print(i + " => ");
            Iterator index = a.listIterator();
            while (index.hasNext()) {
                System.out.print(index.next().toString() + " -> ");
                //index.next();
            }
            System.out.println("null");
            i++;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.printGraph();
        System.out.println("edge count = " + graph.countEdges());
        System.out.println("edge count simple way = " + graph.countEdgesSimple());
    }
}
