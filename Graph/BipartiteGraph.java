import java.util.*;

public class BipartiteGraph {

    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color, -1);
        for (int start = 0; start < v; start++) {
            if (color[start] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                color[start] = 0;
                queue.add(start);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neigh : graph[node]) {
                        if (color[neigh] == -1) {
                            color[neigh] = 1 - color[node];
                            queue.add(neigh);
                        } else if (color[node] == color[neigh]) {
                            return false;
                        }

                    }
                }

            }
        }
        return true;

    }
}