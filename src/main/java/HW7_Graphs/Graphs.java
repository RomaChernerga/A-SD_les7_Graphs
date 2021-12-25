package HW7_Graphs;

public interface Graphs {

    void addVertex(String label);  //добавлять вершины

    boolean addEdge(String startLabel, String secondLabel, String... others);  //добавлять ребра
    boolean addEdge(String startLabel, String secondLabel,int distance);

    int getSize();

    void display();

    // Depth-first search
    void dfs(String startLabel);  //методы обхода

    // Breadth-first search
    void bfs(String startLabel);  //методы обхода
}
