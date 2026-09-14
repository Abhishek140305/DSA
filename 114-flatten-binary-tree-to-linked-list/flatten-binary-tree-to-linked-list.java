class Solution {
    TreeNode temp = null;

    public void flatten(TreeNode root) {
        helper(root);
    }
    private void helper(TreeNode root){
        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(temp != null){
            temp.right = root;
            
        }

        root.left = null;
        temp = root;

        helper(left);
        helper(right);
    }
}