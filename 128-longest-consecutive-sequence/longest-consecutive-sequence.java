class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);


        int maxLength=0;
        int count=1;

        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]== nums[i]){
                continue;
            }

            if(nums[i+1]-nums[i]==1){
                count++;
            }else{
                maxLength= Math.max(maxLength,count);
                count=1;
            }
        }
        maxLength= Math.max(maxLength,count);

        return maxLength;


    }
}