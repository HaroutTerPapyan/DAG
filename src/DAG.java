import java.util.Scanner;
import java.io.*;

/**
 * Created by Harout on 10/9/2015.
 */

public class DAG {

        private String inputFileName;
        private int[][] adjMatrix;
        private int[] visited;
        private int[] paths;
        //other private fields
        private int numVertices;
        private int numEdges;
        private int[] parent;

        public DAG(String inputFileName) throws Exception{
            this.inputFileName = inputFileName;
            numVertices = 0;
            numEdges = 0;
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
            numEdges++;
            adjMatrix[a][b] = 1;
        }
    }

}
