  class Solution {
   public boolean divisorGame(int N) {           

        boolean[] cache = new boolean[N+1];
        if (N== 1){
            cache[1] = false;
            return false;
        }
       
        if (N== 2){
            cache[2] = true;
            return true;
        }
       
        for (int i=1;i*i<=N;i++){
            if (N % i == 0){
                cache[i] = !(divisorGame(N-i));
                return cache[i];
            }
        }
        return false;
    }   
 }