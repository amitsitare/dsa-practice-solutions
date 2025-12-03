import java.util.*;

class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Build map of next greater for nums2
        for (int num : nums2) {
            while (!st.isEmpty() && num > st.peek()) {
                map.put(st.pop(), num);
            }
            st.push(num);
        }

        // Remaining elements have no next greater
        while (!st.isEmpty()) {
            map.put(st.pop(), -1);
        }

        // Prepare result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    // MAIN METHOD TO CALL THE FUNCTION
    public static void main(String[] args) {
        NextGreaterElement obj = new NextGreaterElement();

        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        int[] ans = obj.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans)); // Prints result
    }
}
