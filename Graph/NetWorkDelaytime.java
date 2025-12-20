
import java.util.*;

class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int[] time : times) {
            adj.get(time[0]).add(new int[] { time[1], time[2] });
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[] { 0, k });
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int currDist = cell[0];
            int node = cell[1];
            for (int[] adjCent : adj.get(node)) {
                int weight = adjCent[1];
                int neigh = adjCent[0];
                if (weight + currDist < dist[neigh]) {
                    dist[neigh] = weight + currDist;
                    pq.add(new int[] { dist[neigh], neigh });
                }
            }

        }
        int minTime = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) {
                return -1;
            } else if (minTime < d) {
                minTime = d;
            }
        }
        return minTime;

    }
}