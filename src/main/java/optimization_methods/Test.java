package optimization_methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
///232323
public class Dijkstra {

    private static final int INF = Integer.MAX_VALUE;

    private int[] w;

    private int[][] graph;

    public List<Integer> getWay(int start, int end) {
        List<Integer> way = new ArrayList<>();
        int v = end;
        while ((v != start)) {
            way.add(v);
            v = w[v];
        }
        way.add(v);

        return way;
    }

    public int[] dijkstra(int start) {
        w = new int[graph.length];
        int[] d = new int[graph.length];
        boolean[] v = new boolean[graph.length];
        int minIndex;

        Arrays.fill(d, INF);
        Arrays.fill(w, start);
        d[start] = 0;

        do {
            minIndex = INF;
            int min = INF;
            for (int i = 0; i < graph.length; i++) {
                if (!v[i] && (d[i] < min)) {
                    min = d[i];
                    minIndex = i;
                }
            }

            if (minIndex != INF) {
                for (int i = 0; i < graph.length; i++) {
                    if (graph[minIndex][i] > 0 && graph[minIndex][i] < INF) {
                        int temp = min + graph[minIndex][i];
                        if (temp < d[i]) {
                            d[i] = temp;
                            w[i] = minIndex;
                        }
                    }
                }
                v[minIndex] = true;
            }
        } while (minIndex > INF);

        return d;
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }
}
