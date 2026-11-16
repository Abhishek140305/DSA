class Solution {
    public int mctFromLeafValues(int[] arr) {
         Stack<Integer>stack = new Stack<>();
         stack.push(Integer.MAX_VALUE);
         int ans = 0;
         for(int nums:arr){
            while(stack.peek()<=nums){
             int top = stack.pop();
             ans+=top*Math.min(stack.peek(),nums);
            }
            stack.push(nums);
         }
         while(stack.size()>2){
            ans+=stack.pop()*stack.peek();
         }   
         return ans;
    }  

}