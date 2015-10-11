import java.util.*;
import java.io.*;

/**
 * Created by Harout on 10/9/2015.
 */

public class DAG {

    private String inputFileName;
    private int[][] adjMatrix;
    private int[] visited;
    private int[] paths;
    private int numVertices;
    private int numEdges;
    private int[] parent;
    private int[] inEdge;
    private int startV;
    private Stack<Integer> stack;

    public DAG(String inputFileName) throws Exception{
        this.inputFileName = inputFileName;
        numVertices = 0;
        numEdges = 0;
        readInputData();
    }

    public void printGraph() {
        for(int k = 1; k < numVertices; k++){
            for(int j = 1; j < numVertices; j++)
                System.out.print(adjMatrix[k][j] + " ");
            System.out.println();
        }
        System.out.println();
        checkIncoming(adjMatrix);
        System.out.println();
        startNode(inEdge);
        System.out.println();
        topSort(startV);

    }

    private void readInputData() throws Exception{

        java.io.File inputFile = new java.io.File(inputFileName);
        Scanner input = new Scanner(inputFile);

        numVertices = input.nextInt();
        int a = 0, b = 0;
        adjMatrix = new int[numVertices][numVertices];

        while (input.hasNext()) {
            a = input.nextInt();
            b = input.nextInt();
            numEdges++;
            adjMatrix[a][b] = 1;
        }
    }

    public int[] checkIncoming(int[][] matrix) {
        inEdge = new int[numVertices];
        matrix = adjMatrix;
        for(int i = 1; i < numVertices; i++) {
            for(int j = 1; j < numVertices; j++) {
                if(matrix[j][i] == 1) {
                    inEdge[i] = 1;
                }
            }
        }
        System.out.println("1 indicates incoming edges");
        for(int i = 1; i < numVertices; i++) {
            System.out.print("vertex " + i + " : " + inEdge[i]);
            if(inEdge[i] == 1) {
                System.out.print(" incoming edge");
            }
            System.out.println();
        }
        return inEdge;
    }

    public int startNode(int[] checkVertex) {

        for(int i = 1; i < numVertices; i++) {
            if(checkVertex[i] == 0) {
                System.out.println("Vertex " + i + " is a starting node");
                startV = i;
                break;
            }
        }
        return startV;
    }

    public void topSort(int vertex) {

        int[][] matrix = adjMatrix;
        int[] tSort = new int[numVertices];
        int numIn = 0;

        System.out.println("Topological Sort: " + vertex + " ");

        int i = 1;
        while (i < numVertices) {
            for(int j = 1; j < numVertices; j++) {
                if (matrix[j][i] == 1) {
                    numIn++;
                }
            }
            System.out.println("Num incoming edges for vertex " + i + " is " + numIn);
            i++;
            numIn = 0;
        }
    }

}
