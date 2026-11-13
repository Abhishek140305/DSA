class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int sp = -1; // Points at top of the stack
        stack[++sp] = 0;
        int[] ans = new int[n];
        // First iteration, fill in as if no circular arra
        // Keep track of max for simplicity later
        int max = nums[0];
        for(int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            while(sp >= 0 && nums[stack[sp]] < nums[i]) {
                int index = stack[sp--];
                ans[index] = nums[i];
            }
            stack[++sp] = i;
        }
        while(sp >= 0) {
            int index = stack[sp--];
            if(nums[index] == max) {
                ans[index] = -1;
                continue;
            }
            int i = 0;
            // We could construct a DS to actually jump by looking at the already found next max, but this is enough for now
            while(nums[i] <= nums[index]) {
                i++;
            }
            ans[index] = nums[i];
        }
        return ans;
    }
}