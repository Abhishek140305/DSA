class Solution {
public:
    int sumCounts(vector<int>& nums) {
        int n = nums.size(), total = 0;
        for (int i = 0; i < n; i++) {
            bitset<101> seen;  // values are 1..100
            for (int j = i; j < n; j++) {
                seen.set(nums[j]);  // a repeat doesn't change the count
                int d = seen.count();
                total += d * d;
            }
        }
        return total;
    }
};