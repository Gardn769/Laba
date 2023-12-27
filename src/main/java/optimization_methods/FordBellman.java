package optimization_methods;

import java.util.*;
import java.util.stream.DoubleStream;

public class FordBellman {

    private static final double INF = Double.POSITIVE_INFINITY;
    private double[][] graph;

    public int[] fordBellman(int vertexPath) {
        double[] d = new double[graph.length];
        double[] dPrev;
        Map<Integer, Integer> paths = new HashMap<>();

        boolean firstIteration = true;

        do {
            if (firstIteration) {
                Arrays.fill(d, INF);
                d[0] = 0;
                dPrev = Arrays.copyOf(d, d.length);
                firstIteration = false;
            } else {
                dPrev = d;
                d = Arrays.copyOf(d, d.length);
            }

            for (int i = 0; i < d.length; ++i) {
                double min = INF;
                int minJ = -1;
                for (int j = 0; j < d.length; ++j) {
                    if (dPrev[j] + graph[j][i] < min) {
                        min = dPrev[j] + graph[j][i];
                        minJ = j;
                    }
                }
                d[i] = min;
                paths.put(i, minJ == 0 ? minJ : minJ + 1);
            }

        } while (!Arrays.equals(d, dPrev));

        int t = vertexPath;
        List<Integer> pathToVertex = new ArrayList<>();
        pathToVertex.add(t);
        do {
            t = paths.get(t);
            pathToVertex.add(t);
        } while (t != 0);
        Collections.reverse(pathToVertex);

        return DoubleStream.of(d).mapToInt(dm -> (int) Math.ceil(dm)).toArray();
    }

    public void setGraph(double[][] graph) {
        this.graph = graph;
    }
}
