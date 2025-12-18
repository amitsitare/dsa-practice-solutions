
import java.util.Stack;

public class SubArrayRange {
    public long subArrayRanges(int[] nums) {
        // long sum=0;
        // for(int i=0;i<nums.length;i++){
        // int largest=nums[i];
        // int smallest=nums[i];
        // for(int j=i+1;j<nums.length;j++){
        // largest=Math.max(largest,nums[j]);
        // smallest=Math.min(smallest,nums[j]);
        // sum+=(long)largest-smallest;
        // }
        // }return sum;
        Stack<Integer> st = new Stack<>();
        long totalMax = 0;
        long totalMin = 0;
        for (int i = 0; i <= nums.length; i++) {
            while (!st.isEmpty() && (i == nums.length || nums[st.peek()] < nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                long count = (long) (mid - left) * (right - mid);
                totalMax += (long) (nums[mid] * count);
            }
            st.push(i);
        }
        st.clear();
        for (int j = 0; j <= nums.length; j++) {
            while (!st.isEmpty() && (j == nums.length || nums[st.peek()] > nums[j])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = j;
                long count = (long) (mid - left) * (right - mid);
                totalMin += (long) (nums[mid] * count);
            }
            st.push(j);
        }
        return totalMax - totalMin;

    }
}