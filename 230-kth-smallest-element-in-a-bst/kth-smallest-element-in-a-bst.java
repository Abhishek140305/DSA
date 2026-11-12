class Solution {
    int count = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);

        return ans;
    }

    private void helper(TreeNode root, int k){
        if(root == null) return;

        helper(root.left, k);

        count++;

        if(count == k){
            ans = root.val;
            return;
        }

        if(count < k){
            helper(root.right, k);
        }
    }
}