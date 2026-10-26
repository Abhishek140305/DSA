class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int[][] healthTRD = new int[m][n];

        for (int[] row : healthTRD)
            Arrays.fill(row, Integer.MAX_VALUE);

        // {health, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        healthTRD[m - 1][n - 1] = grid.get(m - 1).get(n - 1);
        pq.offer(new int[] { grid.get(m - 1).get(n - 1), m - 1, n - 1 });

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int h = top[0];
            int r = top[1];
            int c = top[2];

            if (h > healthTRD[r][c])
                continue;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && h + grid.get(nr).get(nc) < healthTRD[nr][nc]) {
                    healthTRD[nr][nc] = h + grid.get(nr).get(nc);
                    pq.offer(new int[] { h + grid.get(nr).get(nc), nr, nc });
                }
            }
        }

        return health - healthTRD[0][0] >= 1;
    }
}