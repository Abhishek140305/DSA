    import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>>al= new ArrayList<>(); //u-->[v, cost]
        for(int i=0;i<n;i++)al.add(new ArrayList<>());
        for(int ed[]: flights){
            int u = ed[0];
            int v = ed[1];
            int cost = ed[2];
            al.get(u).add(new int[]{v,cost});
        }

        int dist[][]=new int[n+1][n+1]; 
        for(int i=0;i<=n;i++)for(int j=0;j<=n;j++)dist[i][j]=Integer.MAX_VALUE;

        PriorityQueue<int []>pq = new PriorityQueue<>((a,b)->(Integer.compare(a[0],b[0])));//dist, vertices, stop
        pq.add(new int[]{0,src,0});

        while(!pq.isEmpty()){
            int top[]= pq.poll();
            int u = top[1];
            int stop=top[2];
            int d = top[0];
            if(u==dst)return d;//till we reach dst, stop = k+1, no issue
            if(stop>k || dist[u][stop]<d)continue;

            for(int arr[]:al.get(u)){
                int v = arr[0];
                int newd= arr[1]+d;
                int newStop = stop+1;
                if(dist[v][newStop]>newd){
                    pq.add(new int[]{newd,v,newStop});
                    dist[v][newStop]=newd;
                }
            }

        }
        return -1;


        
    }
}