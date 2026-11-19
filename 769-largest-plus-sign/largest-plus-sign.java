class Solution {
    
    public class Total {
        int l;
        int r;
        int u;
        int d;
        
        Total(int l, int r, int u, int d){
            this.l = l;
            this.r = r;
            this.u = u;
            this.d = d;
        }
    }
    
    public int orderOfLargestPlusSign(int n, int[][] mine) {
        int[][] mines = new int[n][n];
        
        
        for (int[] row : mines) {
            Arrays.fill(row, 1);
        }
        
        
        for (int[] m : mine) {
            mines[m[0]][m[1]] = 0;
        }
        
        Total[][] nums = new Total[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = new Total(0, 0, 0, 0);
            }
        }
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (mines[i][j] == 0) {
                    sum = 0;
                    nums[i][j].l = sum;
                } else {
                    nums[i][j].l = ++sum;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (mines[i][j] == 0) {
                    sum = 0;
                    nums[i][j].r = sum;
                } else {
                    nums[i][j].r = ++sum;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (mines[j][i] == 0) {
                    sum = 0;
                    nums[j][i].u = sum;
                } else {
                    nums[j][i].u = ++sum;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (mines[j][i] == 0) {
                    sum = 0;
                    nums[j][i].d = sum;
                } else {
                    nums[j][i].d = ++sum;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                max = Math.max(Math.min(nums[i][j].l, Math.min(nums[i][j].r, Math.min(nums[i][j].d, nums[i][j].u))), max);
            }
        }
        
        return max;
    }
}