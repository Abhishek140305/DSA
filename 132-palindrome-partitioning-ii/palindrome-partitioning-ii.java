class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        boolean[][] isPal = new boolean[n][n];
        // Precompute palindrome table using DP
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && 
                   (end - start <= 2 || isPal[start + 1][end - 1])) {
                    isPal[start][end] = true;
                }
            }
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                dp[i] = 0; // No cut needed if s[0...i] is a palindrome
            } else {
                dp[i] = i; // Max cuts: one for each character
                for (int j = 0; j < i; j++) {
                    if (isPal[j + 1][i]) {
                        // If suffix is palindrome, total = cuts for prefix + 1
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}