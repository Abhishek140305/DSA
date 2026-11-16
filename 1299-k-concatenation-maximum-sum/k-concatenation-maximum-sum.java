class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        long maxFirst=-(long)1e18;
        long sum=0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            maxFirst = Math.max(maxFirst,sum);
        }

        long sm = 0;
        long max = -(long)1e18;
        long last = -1;
        for(int i=0;i<n;i++){
            sm = Math.max(sm+arr[i],arr[i]);
            max = Math.max(max,sm);

            if(i==n-1) last = sm;
        }

        long mod = (long)1e9+7;
        k--;
        if(max<0) return 0;
        if(k==0) return (int)(max%mod);

        if(sum>0){
            long next = (k-1)*sum + maxFirst;
            max = Math.max(max,last+next);
        }else{
            max = Math.max(max,last+maxFirst);
        }

        
        
        return (int)(max%mod);
    }
}