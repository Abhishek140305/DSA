class Solution {
public:
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
        unordered_map<int, TreeNode*> nodes;
        unordered_set<int> st;

        for (auto& des : descriptions) {
            int parent = des[0];
            int child = des[1];
            int isLeft = des[2];

            if (nodes.find(parent) == nodes.end()) {
                nodes[parent] = new TreeNode(parent);
            }

            if (nodes.find(child) == nodes.end()) {
                nodes[child] = new TreeNode(child);
            }

            TreeNode* p = nodes[parent];
            TreeNode* c = nodes[child];

            st.insert(child);

            if (isLeft == 1) {
                p->left = c;
            } else {
                p->right = c;
            }
        }

        for (auto& entry : nodes) {
            int val = entry.first;

            if (st.find(val) == st.end()) {
                return entry.second;
            }
        }

        return nullptr;
    }
};