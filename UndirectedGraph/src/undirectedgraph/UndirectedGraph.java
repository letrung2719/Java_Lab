/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package undirectedgraph;

import java.util.Scanner;

/**
 *
 * @author TrungLT
 */
public class UndirectedGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(6);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the start point: ");
        int start = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the end point: ");
        int end = scanner.nextInt();

        System.out.println("This is "
                + (graph.isEdge(start, end) ? "" : " not ") + " an edge");
    }

    private boolean adjacencyMatrix[][];
    private int vertexCount;

    public UndirectedGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacencyMatrix = new boolean[vertexCount][vertexCount];
    }

    public void addEdge(int i, int j) {
        if (i > 0 && i <= vertexCount && j > 0 && j <= vertexCount) {
            adjacencyMatrix[i-1][j-1] = true;
            adjacencyMatrix[j-1][i-1] = true;
        }
    }

    public void removeEdge(int i, int j) {
        if (i > 0 && i <= vertexCount && j > 0 && j <= vertexCount) {
            adjacencyMatrix[i-1][j-1] = false;
            adjacencyMatrix[j-1][i-1] = false;
        }
    }

    public boolean isEdge(int i, int j) {
        if (i > 0 && i <= vertexCount && j > 0 && j <= vertexCount) {
            return adjacencyMatrix[i-1][j-1] || adjacencyMatrix[j-1][i-1];
        } else {
            return false;
        }
    }

}
