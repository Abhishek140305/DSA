class Solution {
    private int solve(int l, int r, String s, int[][] dp) {
        if (r < l) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        if (s.charAt(l) == s.charAt(r)) {
            if (l == r) {
                return dp[l][r] = 1 + solve(l + 1, r - 1, s, dp);
            }
            return dp[l][r] = 2 + solve(l + 1, r - 1, s, dp);
        }

        return dp[l][r] = Math.max(
            solve(l + 1, r, s, dp),
            solve(l, r - 1, s, dp)
        );
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, n - 1, s, dp);
    }
}