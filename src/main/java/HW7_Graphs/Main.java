package HW7_Graphs;

public class Main {
    public static void main(String[] args) {
        testDfs();
//        testGraph();
    }


    private static void testDfs() {
        Graphs graphs = new GraphImpl(10);

        graphs.addVertex("Москва");
        graphs.addVertex("Тула");
        graphs.addVertex("Липецк");
        graphs.addVertex("Воронеж");
        graphs.addVertex("Рязань");
        graphs.addVertex("Тамбов");
        graphs.addVertex("Саратов");
        graphs.addEdge("Москва", "Тула", 100);
        graphs.addEdge("Тула", "Липецк", 140);
        graphs.addEdge("Липецк", "Воронеж", 150);

        graphs.addEdge("Москва", "Рязань", 110);
        graphs.addEdge("Рязань", "Тамбов", 160);
        graphs.addEdge("Тамбов", "Саратов", 125);
        graphs.addEdge("Саратов", "Воронеж", 70);

        graphs.dfs("Москва");


        System.out.println("___________");
    }
    private static void testGraph() {
        Graphs graphs = new GraphImpl(7);

        graphs.addVertex("Москва");
        graphs.addVertex("Тула");
        graphs.addVertex("Липецк");
        graphs.addVertex("Воронеж");
        graphs.addVertex("Рязань");
        graphs.addVertex("Тамбов");
        graphs.addVertex("Саратов");
        graphs.addEdge("Москва", "Тула", 100);
        graphs.addEdge("Тула", "Липецк", 140);
        graphs.addEdge("Липецк", "Воронеж", 150);

        graphs.addEdge("Москва", "Рязань", 110);
        graphs.addEdge("Рязань", "Тамбов", 160);
        graphs.addEdge("Тамбов", "Саратов", 125);
        graphs.addEdge("Саратов", "Воронеж", 70);

        graphs.display();




//        graphs.addEdge("Москва", "Тула", "Липецк", "Воронеж");
//        graphs.addEdge("Москва", "Рязань", "Тамбов", "Саратов", "Воронеж");
//        graphs.addEdge("Москва", "Калуга", "Орел","Курск", "Воронеж");

        System.out.println("Size of graph is " + graphs.getSize());
        graphs.display();
    }


}
