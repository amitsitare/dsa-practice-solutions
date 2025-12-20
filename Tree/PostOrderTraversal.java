
import java.util.*;

class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list1 = new ArrayList<>();
        return postOrder(root, list1);

    }

    public List<Integer> postOrder(TreeNode root, List<Integer> list1) {
        if (root != null) {
            postOrder(root.left, list1);
            postOrder(root.right, list1);
            list1.add(root.val);
        }
        return list1;

    }
}