class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int indexDiff, int valueDiff) {
        int n = nums.size();

        // Brute Force
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n && j<=i+indexDiff;j++){
        //         if(abs(nums[i]-nums[j])<=valueDiff) return true;  
        //     }
        // }
        // return false;

        // Better approach
        int j=0;
        set<int>st;
        for(int i=0;i<n;i++){
            if(i-j > indexDiff){
                st.erase(nums[j]);
                j++;

            }
            auto it = st.lower_bound(nums[i] - valueDiff);
            if(it!=st.end() && *it<=nums[i]+valueDiff) return true;
            st.insert(nums[i]);
        }
        return false;
    }
};