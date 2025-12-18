
import java.util.Stack;

public class SumSubarrayMins {
    public int sumSubarrayMins(int[] arr) {
        // long sum=0;
        // int MOD = 1_000_000_007;
        // for(int i=0;i<arr.length;i++){
        // int smallest=arr[i];
        // for(int j=i;j<arr.length;j++){
        // smallest=Math.min(smallest,arr[j]);
        // sum+=smallest;
        // }
        // }return (int)(sum % MOD);

        int mod = 1_000_000_007;
        long totalMin = 0;
        Stack<Integer> st = new Stack<>();
        for (int j = 0; j <= arr.length; j++) {
            while (!st.isEmpty() && (j == arr.length || arr[st.peek()] > arr[j])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = j;
                long count = (long) (mid - left) * (right - mid);
                totalMin += (long) (arr[mid] * count);
            }
            st.push(j);
        }
        return (int) (totalMin % mod);

    }
}