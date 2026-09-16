/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int MaxSum(TreeNode* node, int& maxsum){
        if(node==NULL)return 0;
        int left=max(0,MaxSum(node->left,maxsum));
        int right=max(0,MaxSum(node->right,maxsum));

        maxsum=max(maxsum,left+right+node->val);
        return max(left,right)+node->val;
    }
     int maxPathSum(TreeNode* root) {
        int maxsum=INT_MIN;
        MaxSum(root, maxsum);
        return maxsum;

    }
};