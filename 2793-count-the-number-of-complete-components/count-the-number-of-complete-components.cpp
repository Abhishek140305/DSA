class Solution {
public:

    struct DSU{
     vector<int>par,sz;
     int c;
     DSU(int n){
        c=n;
        par=vector<int>(n);
        sz=vector<int>(n,1);
        iota(par.begin(),par.end(),0);
     }

     int find(int u){
        return(u==par[u]?u:par[u]=find(par[u]));
     }

     bool unite(int u,int v){
       u=find(u);
       v=find(v);
       if(u==v) return 0;
       --c;
       if(sz[u]<sz[v]) swap(u,v);
        sz[u]+=sz[v];
        par[v]=u;
        return 1;
     }
    };

    int countCompleteComponents(int n, vector<vector<int>>& edges) {
        DSU dsu(n);
        for(auto e:edges){
           dsu.unite(e[0],e[1]);
        }
        vector<int>cnt(n+1);
        //Count edges using the root of each component
        for(auto e:edges){
            cnt[dsu.find(e[0])]++;
        }

        int c=0;

        for(int i=0;i<n;i++){
            if(dsu.find(i)==i){
                int need=(dsu.sz[i]*(dsu.sz[i]-1))/2;
                 c+=(need==cnt[i]);
            }
        }
        return c;
    }
};