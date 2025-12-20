
import java.util.*;

class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });

                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int minutes = -1;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int k = queue.size();
            minutes++;
            for (int i = 0; i < k; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                for (int[] dir : dirs) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nc >= 0 && nr >= 0 && nc < n && nr < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.add(new int[] { nr, nc });
                        fresh--;
                    }
                }

            }
        }
        return fresh == 0 ? minutes : -1;

    }
}