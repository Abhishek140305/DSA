class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindromes (center is at a character)
            count += expand(s, i, i);
            // Case 2: Even length palindromes (center is between two characters)
            count += expand(s, i, i + 1);
        }
        return count;
    }

    private int expand(String s, int left, int right) {
        int count = 0;
        // Expand outwards as long as characters match and pointers are in bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}