import java.util.*;

class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int num : asteroids) {
            while (!st.isEmpty() && num < 0 && st.peek() > 0) {
                int top = st.peek();
                if (top < -num) {
                    st.pop();
                } else if (top == -num) {
                    st.pop();
                    num = 0;
                } else {
                    num = 0;
                }
            }
            if (num != 0) {
                st.push(num);
            }
        }
        int[] res = new int[st.size()];
        int i = 0;
        for (int n : st) {
            res[i++] = n;
        }
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision obj = new AsteroidCollision();

        int[] asteroids = { 5, 10, -5 };
        int[] result = obj.asteroidCollision(asteroids);

        System.out.println("Result:");
        System.out.println(Arrays.toString(result));
    }
}
