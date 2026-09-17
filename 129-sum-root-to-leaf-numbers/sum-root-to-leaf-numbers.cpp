class Solution {
public:
    int path_num(TreeNode* root, int num) {
        if (!root)
            return 0;

        num = num * 10 + root->val;

        if (!root->left && !root->right)
            return num;

        return path_num(root->left, num) +
               path_num(root->right, num);
    }

    int sumNumbers(TreeNode* root) {
        return path_num(root, 0);
    }
};