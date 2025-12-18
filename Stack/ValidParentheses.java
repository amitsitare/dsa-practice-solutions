import java.util.HashMap;
import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                if (st.isEmpty() || map.get(ch) != st.pop()) {
                    return false;
                }
            } else {
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}
