package optimization_methods;

public class Floyd {

    private static final int INF = Integer.MAX_VALUE;

    private int[][] graph;

    public void floyd() {
        for (int i = 0; i < graph.length; ++i) {
            for (int u = 0; u < graph.length; ++u) {
                for (int v = 0; v < graph.length; ++v) {
                    graph[u][v] = Math.min(graph[u][v], graph[u][i] + graph[i][v]);
                }
            }
        }
    }

    public int[][] getGraph() {
        return graph;
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }
}
