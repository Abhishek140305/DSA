class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == '1')
                    arr[j]++;
                else
                    arr[j] = 0;
            ans = Math.max(ans, maximalSquareHelper(arr));
        }
        return ans;
    }

    public int maximalSquareHelper(int[] nums) {
        int n = nums.length;
        int[] st = new int[n + 1];
        int ptr = -1;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            int val = i < n ? nums[i] : 0;
            while (ptr >= 0 && nums[st[ptr]] >= val) {
                int idx = st[ptr--];
                int j = ptr < 0 ? -1 : st[ptr];
                int width = (i - j - 1);
                int side = Math.min(width, nums[idx]);
                res = Math.max(res, side * side);
            }
            st[++ptr] = i;
        }
        return res;
    }
}