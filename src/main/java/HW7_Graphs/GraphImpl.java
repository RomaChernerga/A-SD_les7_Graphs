package HW7_Graphs;

import java.util.*;

public class GraphImpl implements Graphs {

    private final List<Vertex> vertexList; //лист со всеми вершинами
    private final boolean [][] adjMatrix;
    private int distance;

    public GraphImpl(int maxVertexCount) { // указываем максимальный размер массива
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new boolean[maxVertexCount][maxVertexCount];
    }


    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));  // создание новых вершин
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) { // чтобы делать связи сразу с несколькими вершинами
        boolean result = addEdge(startLabel, secondLabel, distance);

        for (String other : others ) {
            result &= addEdge(startLabel,other);
        }

        return result;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if(vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int distance) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if(startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMatrix[startIndex][endIndex] = true;
        return true;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if(adjMatrix[i][j]) {
                    sb.append("-> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }



    private Vertex getNearUnvisitedVertex(Vertex vertex) { // метод для поиска ближайших узлов, которые не посещали еще
        int currentIndex = vertexList.indexOf(vertex); // получаем индекс узла по которому идем
        for (int i = 0; i < getSize(); i++) {
            if(adjMatrix[currentIndex][i] && !vertexList.get(i).isVisited()) {   // если на нашей позиции true и она не посещенная
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void resetVertexVisited() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        stack.add(vertex);   // добавляем в стек
        vertex.setVisited(true);  // true если узел был посещенным

    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        queue.add(vertex);   // добавляем в стек
        vertex.setVisited(true);  // true если узел был посещенным

    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if(startIndex == -1){
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>(); // создаем стек
        Vertex vertex = vertexList.get(startIndex);
        resetVertexVisited();
        // Посещаем узел и начинаем обходить
        visitVertex(stack, vertex);

        while (!stack.isEmpty()) {  // пока стек на пустой
            vertex = getNearUnvisitedVertex(stack.peek());
            if(vertex != null){  // если узел не пустой, мы его посещаем
                visitVertex(stack, vertex);
            } else {
                stack.pop();  // иначе, мы убираем его из стека

            }
        }
    }

    @Override
    public void bfs(String startLabel) {

        int startIndex = indexOf(startLabel);
        if(startIndex == -1){
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>(); // создаем стек
        Vertex vertex = vertexList.get(startIndex);
        resetVertexVisited();
        // Посещаем узел и начинаем обходить
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {  // пока стек на пустой
            vertex = getNearUnvisitedVertex(queue.peek());
            if(vertex != null){  // если узел не пустой, мы его посещаем
                visitVertex(queue, vertex);
            } else {
                queue.remove();  // иначе, мы убираем его из стека
            }
        }

    }
}
