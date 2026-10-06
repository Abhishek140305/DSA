class Solution {
    public String reverseWords(String s) {

        // Remove leading/trailing spaces
        // and split into individual words
        String[] words = s.trim().split("\\s+");

        // Used to build the final answer
        StringBuilder ans = new StringBuilder();

        // Traverse words from right to left
        for(int i = words.length - 1; i >= 0; i--) {

            // Add current word
            ans.append(words[i]);

            // Add space between words
            // but not after the last word
            if(i != 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}