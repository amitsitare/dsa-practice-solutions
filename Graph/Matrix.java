import java.util.*;

class Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dest = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    vis[i][j] = true;
                }
            }
        }
        int[][] direction = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (!queue.isEmpty()) {
            int[] value = queue.poll();
            int col = value[1];
            int row = value[0];
            for (int[] dir : direction) {
                int newCol = col + dir[1];
                int newRow = row + dir[0];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !vis[newRow][newCol]) {
                    dest[newRow][newCol] = dest[row][col] + 1;
                    queue.offer(new int[] { newRow, newCol });
                    vis[newRow][newCol] = true;
                }

            }
        }
        return dest;
    }
}
