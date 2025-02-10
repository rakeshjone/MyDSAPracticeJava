package Graphs;

public class GraphMatrixImpl {
    int vertices;
    int[][] matrix;

    GraphMatrixImpl(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
       if (source < vertices && destination < vertices) {
            matrix[source][destination] = 1;
            //for undirected graph uncomment below
            matrix[destination][source] = 1;
       }
    }

    public void printGraph() {
        for (int[] a: matrix) {
            for (int b: a) {
                System.out.print(b + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        GraphMatrixImpl graphMatrix = new GraphMatrixImpl(6);
        graphMatrix.addEdge(0,1);
        graphMatrix.addEdge(2,5);
        graphMatrix.addEdge(3,0);
        graphMatrix.addEdge(4,2);
        graphMatrix.printGraph();
    }
}
