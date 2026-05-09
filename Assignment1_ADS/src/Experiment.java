public class Experiment {
    public void runTraversals(Graph g, int start) {
        long startBfs = System.nanoTime();
        g.bfs(start);
        long endBfs = System.nanoTime();
        System.out.println("BFS Execution Time: " + (endBfs - startBfs) + " ns");

        long startDfs = System.nanoTime();
        g.dfs(start);
        long endDfs = System.nanoTime();
        System.out.println("DFS Execution Time: " + (endDfs - startDfs) + " ns");
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};
        for (int size : sizes) {
            System.out.println("--- Testing Graph Size: " + size + " ---");
            Graph g = new Graph();
            for (int i = 0; i < size; i++) g.addVertex(new Vertex(i));
            for (int i = 0; i < size - 1; i++) g.addEdge(i, i + 1);
            runTraversals(g, 0);
        }
    }
}