class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1]; // larger end first
            }
            return a[0]-b[0]; // sort start ascending
        });
        int curr=0,farthest=0,i=0,ans=0;
        while(curr<time){
            while(i<clips.length&&clips[i][0]<=curr){ // take all clips whose start is within current covered range
                farthest=Math.max(farthest,clips[i][1]);  // take the farthest end from these clips
                i++;
            }
            if(farthest==curr){//if farthest and curr are same then we cant extend the coverage
                return -1;
            }
            ans++; // number of clips used
            curr=farthest; // update the curr end to farthest
        }
        return ans;
    }
}