class Solution {
    char[] ch;
    Integer[][] dp;
    public int strangePrinter(String s) {
        ch = s.toCharArray();
        int n = ch.length;
        dp = new Integer[n][n];

        return helper(0,n-1);
    }

    private int helper(int s,int e) {
        if(s > e)
            return 0;
        
        if(dp[s][e] != null)
            return dp[s][e];
        
        // We are printing this character seperately
        int ans = 1 + helper(s+1,e);

        // What if we can print this character at k along with the previous substring
        // When can this be possible ? only when the character at k == character at i
        for(int k=s+1;k<=e;k++) {
            if(ch[s] != ch[k])
                continue;
            
            int prollyBetterAns = helper(s,k-1) + helper(k+1,e);
            ans = Math.min(ans,prollyBetterAns);
        }

        return dp[s][e] = ans;
    }
}