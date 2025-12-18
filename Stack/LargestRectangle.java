
import java.util.Stack;

public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int currentBar = (i == heights.length) ? 0 : heights[i];
            while (!st.isEmpty() && currentBar < heights[st.peek()]) {
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