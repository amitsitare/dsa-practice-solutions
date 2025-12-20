
import java.util.*;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sr, sc });
        int currentColor = image[sr][sc];
        if (currentColor == color) {
            return image;
        }
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            image[row][col] = color;
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= 0 && c >= 0 && r < image.length && c < image[0].length && image[r][c] == currentColor) {
                    queue.add(new int[] { r, c });
                }
            }
        }
        return image;

    }
}