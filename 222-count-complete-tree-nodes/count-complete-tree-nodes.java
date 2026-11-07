/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)return 0;

        int lh= findleftHight(root);
        int rh= findrightHight(root);

        if(lh==rh)return (2<<lh)-1;

        return 1+countNodes(root.left)+countNodes(root.right);
    }
    private int findleftHight(TreeNode root){
        int level=0;
        while(root.left!=null){
            level++;
            root=root.left;
        }
        return level;
    }
    private int findrightHight(TreeNode root){
        int level=0;
        while(root.right!=null){
            level++;
            root=root.right;
        }
        return level;
    }
}