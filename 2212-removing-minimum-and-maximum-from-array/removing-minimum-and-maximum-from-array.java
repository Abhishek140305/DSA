class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int maxIndex = -1;
        int minIndex = -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(min > nums[i]){
                min = nums[i];
                minIndex = i;
            }

            if(max < nums[i]){
                max = nums[i];
                maxIndex = i;
            }
        }

        int diff = Math.abs(maxIndex - minIndex);

        boolean maxG = maxIndex > minIndex;

        // Remove both from the same side
        int case1 = n - diff + 1;

        // Remove both from the left
        int case2 = maxG ? maxIndex + 1 : minIndex + 1;

        // Remove from both sides
        int case3 = maxG ? n - minIndex : n - maxIndex;

        return Math.min(case1, Math.min(case2, case3));
    }
}