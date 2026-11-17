class Solution {
    public int minDistance(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        int n = str1.length;
        int m = str2.length;

        int[][] dp = new int[n + 1][m + 1];

        // Standard LCS DP approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Final Formula: n + m - 2 * LCS
        return n + m - 2 * dp[n][m];
    }
}