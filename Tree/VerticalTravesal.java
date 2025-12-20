class VerticalTravesal {
    class Pair {
        int row;
        int col;
        TreeNode node;

        public Pair(TreeNode node, int row, int col) {
            this.col = col;
            this.node = node;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.add(new Pair(root, 0, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            TreeNode node = pair.node;
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).add(node.val);
            if (node.left != null)
                queue.add(new Pair(node.left, row + 1, col - 1));
            if (node.right != null)
                queue.add(new Pair(node.right, row + 1, col + 1));
        }
        for (TreeMap<Integer, PriorityQueue<Integer>> val : map.values()) {
            List<Integer> order = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : val.values()) {
                while (!nodes.isEmpty()) {
                    order.add(nodes.poll());
                }
            }
            result.add(order);
        }
        return result;

    }
}