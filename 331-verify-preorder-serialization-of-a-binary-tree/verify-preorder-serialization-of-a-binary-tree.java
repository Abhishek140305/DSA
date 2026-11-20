class Solution {
    public boolean isValidSerialization(String preorder) {
        int cnt = 0, m = 0;
        int n = preorder.length();
        for (int i = 0; i < n; i++) {
            if (preorder.charAt(i) == ',') continue;
            while (i < n && preorder.charAt(i) != ',') i++;
            i--;
            if (preorder.charAt(i) != '#') cnt++;
            else m++;
            if (m == cnt + 1) {
                if (i == n - 1) return true;
                else return false;
            }
        }
        return false;
    }
}