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
    // dfs that carries the path built so far in s
    void paths(TreeNode* root,vector<string>&ans,string s){
        s+=to_string(root->val); // add current node's value to the path
        if(!root->left&&!root->right){
            ans.push_back(s); // leaf reached, save complete path
            return;
        }
        s+="->"; // separator before going deeper
        if(root->left){
            paths(root->left,ans,s); // explore left subtree
        }
        if(root->right){
            paths(root->right,ans,s); // explore right subtree
        }
         
    }
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string>ans; // stores all root-to-leaf paths
        string s=""; // running path string
        paths(root,ans,s);
        return ans;
    }
};