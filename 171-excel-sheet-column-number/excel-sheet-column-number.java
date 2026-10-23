class Solution {
    public int titleToNumber(String columnTitle) {
        int count=0;
        int n=columnTitle.length();
        for(int i=0;i<n;i++){
            count=count*26+(columnTitle.charAt(i)-'A'+1);
        }
        return count;
    }
}