
import java.util.*;

public class NextElement {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < n * 2; i++) {
            int curr = nums[i % n];
            while (!st.isEmpty() && nums[st.peek()] < curr) {
                result[st.pop()] = curr;
            }
            if (i < n) {
                st.push(i);
            }
        }

        return result;

    }
}