class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return Symmetric(root.left, root.right);

    }

    public boolean Symmetric(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if ((r1 == null || r2 == null) || (r1.val != r2.val)) {
            return false;

        }
        return Symmetric(r1.left, r2.right) && Symmetric(r1.right, r2.left);
    }
}