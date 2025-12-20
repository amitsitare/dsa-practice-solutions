class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int provinces = 0;
        for (int start = 0; start < n; start++) {
            if (!vis[start]) {
                provinces++;
                dfs(start, vis, isConnected, n);
            }
        }
        return provinces;

    }

    public void dfs(int s, boolean[] vis, int[][] isConnected, int n) {
        vis[s] = true;
        for (int i = 0; i < n; i++) {
            if (isConnected[s][i] == 1 && !vis[i]) {
                dfs(i, vis, isConnected, n);
            }
        }
    }

}