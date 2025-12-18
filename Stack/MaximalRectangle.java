
import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[] heights = new int[col];
        int maxRectangle = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxRectangle = Math.max(maxRectangle, largestRectanle(heights));
        }
        return maxRectangle;

    }

    public int largestRectanle(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int currentEle = i == heights.length ? 0 : heights[i];
            while (!st.isEmpty() && heights[st.peek()] > currentEle) {
                int idx = st.pop();
                int height = heights[idx];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            st.push(i);
        }
        return maxArea;
    }
}