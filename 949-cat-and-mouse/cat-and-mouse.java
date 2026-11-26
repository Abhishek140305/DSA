import java.util.*;

class Solution {
    public int catMouseGame(int[][] graph) {
        int n = graph.length;

        // color[mouse][cat][turn]
        // 0 = Draw, 1 = Mouse wins, 2 = Cat wins
        int[][][] color = new int[n][n][2];

        // Number of possible moves from each state
        int[][][] degree = new int[n][n][2];

        for (int mouse = 0; mouse < n; mouse++) {
            for (int cat = 0; cat < n; cat++) {
                degree[mouse][cat][0] = graph[mouse].length;

                int catMoves = 0;
                for (int next : graph[cat]) {
                    if (next != 0) catMoves++;
                }
                degree[mouse][cat][1] = catMoves;
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        // Mouse reaches hole -> Mouse wins
        for (int cat = 1; cat < n; cat++) {
            color[0][cat][0] = 1;
            color[0][cat][1] = 1;

            queue.offer(new int[]{0, cat, 0, 1});
            queue.offer(new int[]{0, cat, 1, 1});
        }

        // Cat catches mouse -> Cat wins
        for (int pos = 1; pos < n; pos++) {
            color[pos][pos][0] = 2;
            color[pos][pos][1] = 2;

            queue.offer(new int[]{pos, pos, 0, 2});
            queue.offer(new int[]{pos, pos, 1, 2});
        }

        while (!queue.isEmpty()) {
            int[] state = queue.poll();

            int mouse = state[0];
            int cat = state[1];
            int turn = state[2];
            int result = state[3];

            // Find all states that could lead to the current state
            if (turn == 0) {
                // Previous turn was Cat's
                for (int prevCat : graph[cat]) {
                    if (prevCat == 0) continue;

                    process(
                        mouse, prevCat, 1,
                        mouse, cat, result,
                        color, degree, queue
                    );
                }
            } else {
                // Previous turn was Mouse's
                for (int prevMouse : graph[mouse]) {
                    process(
                        prevMouse, cat, 0,
                        mouse, cat, result,
                        color, degree, queue
                    );
                }
            }
        }

        return color[1][2][0];
    }

    private void process(
        int prevMouse, int prevCat, int prevTurn,
        int mouse, int cat, int result,
        int[][][] color,
        int[][][] degree,
        Queue<int[]> queue
    ) {
        // Already determined
        if (color[prevMouse][prevCat][prevTurn] != 0) {
            return;
        }

        // If the player whose turn it is can move to their winning state
        if ((prevTurn == 0 && result == 1) ||
            (prevTurn == 1 && result == 2)) {

            color[prevMouse][prevCat][prevTurn] = result;

            queue.offer(
                new int[]{prevMouse, prevCat, prevTurn, result}
            );
        } else {
            // This move leads to opponent's winning state
            degree[prevMouse][prevCat][prevTurn]--;

            // All possible moves lead to opponent winning
            if (degree[prevMouse][prevCat][prevTurn] == 0) {
                int loseResult = (prevTurn == 0) ? 2 : 1;

                color[prevMouse][prevCat][prevTurn] = loseResult;

                queue.offer(
                    new int[]{
                        prevMouse,
                        prevCat,
                        prevTurn,
                        loseResult
                    }
                );
            }
        }
    }
}