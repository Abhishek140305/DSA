class Solution {
    private Map<String, Integer> memo;
    
    public int leastOpsExpressTarget(int x, int target) {
        memo = new HashMap<>();
        // We subtract 1 from final result because problem counts operators between numbers
        return dfs(x, target) - 1;
    }
    
    private int dfs(long x, long target) {
        // Base case: if target is 0, we don't need any more operations
        if (target == 0) return 0;
        
        // Create a unique key for memoization
        String key = x + "_" + target;
        if (memo.containsKey(key)) return memo.get(key);
        
        // If target is less than x, we have two choices:
        // 1. Add x/x target times
        // 2. Subtract x/x (target-x) times from x
        if (target < x) {
            // Cost of x/x is 2 operators (multiplication and division)
            int ops = (int) (2 * target);
            // Compare with approach of getting to target by subtracting from x
            ops = Math.min(ops, (int) (2 * (x - target) + 1));
            memo.put(key, ops);
            return ops;
        }
        
        // Find the largest power of x that doesn't exceed target
        long sum = x;
        int power = 0;
        while (sum <= target) {
            sum *= x;
            power++;
        }
        sum /= x;
        
        // Try two approaches:
        // 1. Use the largest power and add remaining
        // 2. Use the next larger power and subtract
        int ops = power + dfs(x, target - sum);
        
        // Check if using next power and subtracting is better
        if (sum * x - target < target) {
            ops = Math.min(ops, power + 1 + dfs(x, sum * x - target));
        }
        
        memo.put(key, ops);
        return ops;
    }
}