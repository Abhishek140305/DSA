class NumArray {
private:
    vector<int> tree;
    vector<int> arr;
    int n;

    int lowBit(int i) {
        return i & (-i);
    }

    void add(int i, int delta) {
        while (i <= n) {
            tree[i] += delta;
            i += lowBit(i);
        }
    }

    int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowBit(i);
        }
        return sum;
    }

public:
    NumArray(vector<int>& nums) {
        arr = nums;
        n = nums.size();
        tree.resize(n + 1, 0);
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }
    
    void update(int index, int val) {
        int delta = val - arr[index];
        arr[index] = val;
        add(index + 1, delta);
    }
    
    int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
};
