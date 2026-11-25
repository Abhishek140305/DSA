class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int i=0,c=0;
        for(i=0;i<patterns.length;i++)
        {
            if(word.contains(patterns[i]))
                c++;
        }
        return c;
    }
}