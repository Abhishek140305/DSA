class Solution {

    int[][] dp;
    int[] prefix;
    int k;

    int INF = Integer.MAX_VALUE / 2;

    public int mergeStones(int[] stones, int k) {

        int n = stones.length;

        // Check if it is possible to end with one pile
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        this.k = k;

        // Prefix sum
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        // Memoization table
        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, n - 1);
    }

    private int helper(int i, int j) {

        // One pile needs no cost
        if (i == j) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = INF;

        // Try every valid split
        for (int mid = i; mid < j; mid += k - 1) {

            int left = helper(i, mid);
            int right = helper(mid + 1, j);

            ans = Math.min(ans, left + right);
        }

        // Can this interval become exactly one pile?
        if ((j - i) % (k - 1) == 0) {

            int sum = prefix[j + 1] - prefix[i];

            ans += sum;
        }

        return dp[i][j] = ans;
    }
}