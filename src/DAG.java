
import java.util.*;
import java.io.*;

/**
 * Created by Harout on 10/9/2015.
 */

public class DAG {

    private String inputFileName;
    private int[][] adjMatrix;
    private int numVertices;
    private int numEdges;
    private int[] inEdge;
    private int[] startV = new int[50];
    private int[] visited = new int[50];
    private ArrayList remove = new ArrayList();
    private int[] topologicalSortedSet;
    private int[] visit = new int[50];

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
        //startNode(inEdge);
        System.out.println();
        //topSort(startV);
        System.out.println();
        topologicalSort(startV,adjMatrix);

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

    public int[] startNode(int[] checkVertex) {

        for(int i = 1; i < numVertices; i++) {
            if(checkVertex[i] == 0) {
                System.out.println("Vertex " + i + " is a starting node");
                startV[i] = i;
                visited[i] = 1;
                //break;
            }
            else {
                System.out.println("Vertex " + i + " is NOT a starting node");
                remove.add(i);
            }
        }
        System.out.println("Visited: " + visited);
        System.out.println("To Remove: " + remove);
        return startV;
    }

    public void topSort(int vertex) {

        int[][] matrix = adjMatrix;
        int[] tSort = new int[numVertices];
        int numIn = 0;

        //System.out.println("Topological Sort: " + vertex + " ");

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

        System.out.println();
        ArrayList req = new ArrayList();
        int v = 1; //vert counter
        while (v < numVertices){

            for(int j = 1; j < numVertices; j++) {
                req = new ArrayList();
                if(matrix[j][v] == 1) {
                    System.out.println("Path from " + j + " to " + v);
                    for(int k = 1; k < numVertices; k++) {
                        if(matrix[k][j] == 1){
                            System.out.println(j + " req " + k);
                            req.add(k);
                        }

                    }
                    /*
                    //find startNode, put into visited, redraw adjmatrix
                    //compare with remove[]?
                    if(visited.containsAll(req)) {
                        //System.out.println("req " + req);
                        if(!visited.contains(j)) {
                            visited.add(j);
                            remove.remove(j);
                        }
                    }
                    */

                }

            }

            v++;
        }
        System.out.println();
        System.out.println("Topo sort " + visited);
    }

    public int[] topologicalSort(int[] findSourceV, int[][] adjMatrix) {
        topologicalSortedSet = new int[numVertices];
        int startVertex = 0;
        int i = 0;
        int j = 0;
        int arrSize = 0;
        //Step 1: Find a Starting point from array we created findSourceVertices[]
        //for(int i = 0; i < numTestV; i++){
        while (arrSize < numVertices) { //keep going until it's done
            i = 0;
            while (i < numVertices) {
                if (visit[i] == 0 && startV[i] == 0) {
                    startVertex = i;

                    System.out.println("Starting Vertex: " + startVertex);

                    visit[i] = 1;
                    topologicalSortedSet[j] = i;
                    j++;

                    arrSize++;   //increment size of topological array
                    System.out.println("Size of topological arry is " + arrSize);
                } else {
                    i++;
                }
                //break;
            }
            //findStart();
            startNode(inEdge);
            //checkIncoming(adjMatrix);

        }
        //}

        //System.out.println("Starting Vertex: " + startVertex);
        System.out.println("Returned by Topological Sort");
        for (int m = 0; m < numVertices; m++) {
            System.out.println(topologicalSortedSet[m]);
        }
        return topologicalSortedSet;

    }

    public int[] findStart() {
        System.out.println("Finding start");

        startV = new int[numVertices]; //Initialize start point array
        for (int m = 0; m < numVertices; m++) { //for column
            if (visited[m] == 1) {
                System.out.println(m + " is alreaqdy visited!");
                //   //skip this one if it is already in the visited nodes
            } else {
                for (int j = 0; j < numVertices; j++) { //for row
                    //System.out.println("j is " + j + " m is " + m + " value is " + testDag[m][j]);
                    if (adjMatrix[m][j] == 1 && visited[j] == 0) { //check if incoming edge. This assumes that there is never an edge from vertex to itself. !!!ALSO CHECK THAT THE NODE THAT HAS AN EDGE TO IT HASN"T BEEN VISITED YET !!!
                        startV[m] = 1; //If incoming edge exists, change value from zero to one.

                    }

                }
            }
        }
        return startV; //Return array containing possible starting points
    }



}
