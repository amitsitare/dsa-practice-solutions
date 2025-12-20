
import java.util.*;

class ShortestPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 1 });
        grid[0][0] = 1;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int dist = cell[2];
            if (r == n - 1 && c == n - 1) {
                return dist;
            }
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nc >= 0 && nc < n && nr >= 0 && nr < n && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1;
                    queue.add(new int[] { nr, nc, dist + 1 });
                }
            }

        }
        return -1;

    }
}