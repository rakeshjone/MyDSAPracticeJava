package Graphs;

import LinkedListProbs.DooublyLinkedList;
import LinkedListProbs.DoublyListWithTail;

import java.util.*;

public class MyGraph {
    int vertices;
    DoublyListWithTail<Integer> list[];

    public MyGraph(int vertices) {
        this.vertices = vertices;
        list = new DoublyListWithTail[vertices];

        for (int i = 0; i < vertices; i++) {
            list[i] = new DoublyListWithTail<Integer>();
        }
    }

    public int countEdges() {
        int edgeCount = 0;
        for (DoublyListWithTail l:list) {
            DoublyListWithTail<Integer>.Node index = l.getHead();
            while (index!=null) {
                edgeCount++;
                index=index.next;
            }
        }
        return edgeCount/2;
    }

    public int countEdgesSimple() {
        int edgeCount = 0;
        for (DoublyListWithTail l:list) {
            edgeCount=edgeCount+ l.getSize();
        }
        return edgeCount/2;
    }

    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.list[source].insertAtEnd(destination);
            //if this is an undirected graph uncomment below
            //this.list[destination].insertAtEnd(source);
        }
    }

    public void printGraph() {
        int i = 0;
        for (DoublyListWithTail<Integer> a: list) {
            System.out.print(i + " => ");
            DoublyListWithTail<Integer>.Node index = a.getHead();
            while (index!=null) {
                System.out.print(index.data + " -> ");
                index = index.next;
            }
            System.out.println("null");
            i++;
        }
    }

    public List<Integer> bFSTraversal(MyGraph graph, int source) {
        Queue<Integer> queue = new PriorityQueue<>(vertices);
        int vertices = graph.vertices;
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices];

         queue.add(source);
         visited[source] = true;

         while (!queue.isEmpty()) {
             int currentVertex = queue.poll();
             result.add(currentVertex);

             DoublyListWithTail<Integer>.Node index = graph.list[currentVertex].getHead();
             while (index!=null) {
                 if (!visited[index.data]) {
                     queue.add(index.data);
                     visited[index.data] = true;
                 }
                 index=index.next;
             }
         }

         return result;
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.printGraph();
        System.out.println("edge count = " + graph.countEdges());
        System.out.println("edge count simple way = " + graph.countEdgesSimple());
    }
}
