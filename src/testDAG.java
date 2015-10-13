import java.util.Scanner;

/**
 * Created by Harout on 10/9/2015.
 */
public class testDAG {
    public static void main( String[] args) throws Exception {

        topSort g1 = new topSort("testCase3.txt");
        g1.printGraph();
    }

}

/*
----------------testCase2 (test problem 4) output----------------
0 1 0 0 1
0 0 0 1 0
0 1 0 1 0
0 0 0 0 1
0 0 0 0 0

Topological Sort { 3  1  2  4  5  }
Process finished with exit code 0

----------------testCase3.txt (10 nodes) output----------------
0 1 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0 0
0 0 0 0 1 0 1 0 0 0
0 0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 1 0
0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 1 0 0

Topological Sort { 3  1  2  4  5  7  6  9  10  8  }
Process finished with exit code 0
 */
