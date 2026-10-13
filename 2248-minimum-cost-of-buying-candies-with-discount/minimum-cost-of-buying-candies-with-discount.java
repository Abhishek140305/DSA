class Solution {
    public int minimumCost(int[] cost) {
        
        int min_cost = 0;
        int count = 0;
        Arrays.sort(cost);
        for(int i=cost.length-1; i>=0; i--){

            count ++;
            if(count%3 == 0){
                continue;
            }
            min_cost += cost[i];
        }

        return min_cost;
    }
}