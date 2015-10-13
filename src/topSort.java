import java.util.*;

public class topSort {

    private String inputFileName;
    public static int[][] adjMatrix;
    public static int[] visited;
    public static int numVertices;
    public static int[] sourceV;
    public static int[] topSorted;
    public static int arrSize = 0;

    public topSort(String inputFileName) throws Exception{
        this.inputFileName = inputFileName;
        numVertices = 0;
        readInputData();
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
            adjMatrix[a][b] = 1;
        }
    }

    public void printGraph() {
        for (int i = 1; i < adjMatrix.length; i++) {
            for (int j = 1; j < adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        visit();
        printTopSort();
    }

    public void printTopSort() {
        startNode();
        topSort(sourceV, adjMatrix);
        System.out.println();
        System.out.print("Topological Sort { ");
        for(int i = numVertices - 1; i > 0; i--) {
            System.out.print(topSorted[i] + "  ");
        }
        System.out.print("}");
    }

    public void visit(){
        visited = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = 0;
        }
    }
    public static int[] startNode() {
        sourceV = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            if (visited[i] == 0) {
                for (int j = 0; j < numVertices; j++) { //for row
                    if (adjMatrix[i][j] == 1 && visited[j] == 0) {
                        sourceV[i] = 1;
                    }
                }
            }
        }
        return sourceV;
    }

    public static int[] topSort(int[] source, int[][] matrix) {
        topSorted = new int[numVertices];
        int i = 0;
        int j = 0;
        while (arrSize < numVertices) {
            i = 0;
            while (i < numVertices) {
                if (visited[i] == 0 && sourceV[i] == 0) {
                    visited[i] = 1;
                    topSorted[j] = i;
                    j++;
                    arrSize++;
                }
                else {
                    i++;
                }
            }
            startNode();
        }
        return topSorted;
    }
}
