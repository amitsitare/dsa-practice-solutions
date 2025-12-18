class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxRight[n - 1] = height[n - 1];
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
            maxRight[n - i - 1] = Math.max(height[n - i - 1], maxRight[n - i]);

        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return sum;

    }
}