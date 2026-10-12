    class Solution {
    public:
        bool check(int idx,string wd,unordered_set<string>& s,vector<int>& dp){
            int le=wd.size();
            if(idx==le) return true;
            if(dp[idx]!=-1) return dp[idx];
            for(int i=idx;i<wd.size();i++){
                string p=wd.substr(idx,i-idx+1);
                string l=wd.substr(i+1,wd.size()-i);
                if (idx==0 && i==le-1) continue;
                if(s.find(p)!=s.end() && (s.find(l)!=s.end() || check(i+1,wd,s,dp)))
                return dp[idx]=true;
            }
            return dp[idx]=false;
        }

        vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
            unordered_set<string> s;
            vector<string> ans;
            for(string wd:words)
            s.insert(wd);
            for(string wd:words){
                vector<int> dp(wd.size(),-1);
                if(check(0,wd,s,dp))
                ans.push_back(wd);
            }
            return ans;
        }
    };