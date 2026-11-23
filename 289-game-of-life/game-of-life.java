class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            temp[i] = board[i].clone();
        }

        int[] r = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] c = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;

                for (int k = 0; k < 8; k++) {
                    int rn = i + r[k];
                    int cn = j + c[k];

                    if (rn >= 0 && rn < m && cn >= 0 && cn < n) {
                        if (temp[rn][cn] == 1) count++;
                    }
                }

                if (temp[i][j] == 1) {
                    if (count < 2) board[i][j] = 0;
                    else if (count == 2 || count == 3) board[i][j] = 1;
                    else board[i][j] = 0;
                } else {
                    if (count == 3) board[i][j] = 1;
                }
            }
        }
    }
}