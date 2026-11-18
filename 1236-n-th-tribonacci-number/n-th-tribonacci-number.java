class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        int one = 0; 
        int two = 1; 
        int three = 1;
        
        for(int i = 2; i < n; i++){
            int temp = one + two + three;
            one = two;
            two = three;
            three = temp;
        }
        return three;
    }
}