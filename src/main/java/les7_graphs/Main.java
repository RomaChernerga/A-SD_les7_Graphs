package les7_graphs;

public class Main {
    public static void main(String[] args) {
//        testGraph();
        testDfs();
//        testBfs();
    }

    private static void testGraph() {
        Graphs graphs = new GraphImpl(7);

        graphs.addVertex("A");
        graphs.addVertex("B");
        graphs.addVertex("C");
        graphs.addVertex("D");

        graphs.addEdge("A", "B", "C");
        graphs.addEdge("B", "C", "D");
        graphs.addEdge("C", "C", "B",  "D");
        graphs.addEdge("D", "B", "C");

        System.out.println("Size of graph is " + graphs.getSize());
        graphs.display();
    }
    private static void testDfs() {
        Graphs graphs = new GraphImpl(7);

        graphs.addVertex("A");
        graphs.addVertex("B");
        graphs.addVertex("C");
        graphs.addVertex("D");
        graphs.addVertex("E");
        graphs.addVertex("F");
        graphs.addVertex("G");

        graphs.addEdge("A", "B", "C", "D");
        graphs.addEdge("B", "E");
        graphs.addEdge("D", "F");
        graphs.addEdge("F", "G");

        graphs.dfs("A");

    }

    private static void testBfs() {

        Graphs graphs = new GraphImpl(8);

        graphs.addVertex("A");
        graphs.addVertex("B");
        graphs.addVertex("C");
        graphs.addVertex("D");
        graphs.addVertex("E");
        graphs.addVertex("F");
        graphs.addVertex("G");
        graphs.addVertex("H");

        graphs.addEdge("A", "B", "C", "D");
        graphs.addEdge("B", "E");
        graphs.addEdge("E", "H");
        graphs.addEdge("C", "F");
        graphs.addEdge("D", "G");

        graphs.bfs("A");


    }
}
