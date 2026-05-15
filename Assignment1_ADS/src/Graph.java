import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        adjList.get(from).add(new Edge(from, to));
    }

    public void printGraph() {
        for (int key : adjList.keySet()) {
            System.out.println(key + ": " + adjList.get(key));
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (Edge edge : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(edge.getDestination())) {
                    visited.add(edge.getDestination());
                    queue.add(edge.getDestination());
                }
            }
        }
        System.out.println();
    }   

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");
        for (Edge edge : adjList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(edge.getDestination())) {
                dfsRecursive(edge.getDestination(), visited);
            }
        }
    }
}