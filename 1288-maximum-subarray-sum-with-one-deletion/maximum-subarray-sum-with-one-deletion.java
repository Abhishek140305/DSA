class Solution {
    public int maximumSum(int[] arr) {
        // Best subarr sum ending at current index when we have NOT deleted any ele.
        int noDelete=arr[0];
        // Best subarr sum ending at current index when we have already deleted exactly one ele.
        int oneDelete=0; 
        int ans=noDelete; // Best answer found anywhere in the array.
        for(int i=1;i<arr.length;i++){
            // Save previous states because both new states
            // depend on the values from the previous index.
            int prevNoDelete=noDelete;
            int prevOneDelete=oneDelete;
            noDelete=Math.max(prevNoDelete+arr[i],arr[i]);// Use basic max Kadane for no deletion
           // One deletion:
            // 1. Deletion already happened earlier,
            //    so include the current element with prev state of one-delete.
            // 2. Delete the current element,
            //    so take the prev no-deletion state without adding arr[i].
            oneDelete=Math.max(prevOneDelete+arr[i],prevNoDelete);
            ans=Math.max(ans,Math.max(noDelete,oneDelete)); // Update best max subarr sum
        }
        return ans;
    }
}