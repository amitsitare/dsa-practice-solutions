
import java.util.*;

class PreorderTravesal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list1 = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node == null) {
                return list1;
            }
            if (node != null) {
                list1.add(node.val);
            }
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }
        return list1;

    }

}