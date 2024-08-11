package org.example.semester_02.week_03.lectureOfRecursion;

public class CrazyRobot {
        private boolean[][] visited = new boolean[30][30];
        private int[] dx = {1, -1, 0, 0}; // E, W, S, N
        private int[] dy = {0, 0, 1, -1}; // E, W, S, N
        private double[] prob = new double[4];
        private double result = 0.0;

        public double getProbability(int n, int east, int west, int south, int north) {
            prob[0] = east / 100.0;
            prob[1] = west / 100.0;
            prob[2] = south / 100.0;
            prob[3] = north / 100.0;

            // Start from the center of the grid to avoid out-of-bounds issues
            visited[15][15] = true;
            dfs(15, 15, n, 1.0);
            return result;
        }

        private void dfs(int x, int y, int steps, double probability) {
            if (steps == 0) {
                result += probability;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, steps - 1, probability * prob[i]);
                    visited[nx][ny] = false; // Backtrack
                }
            }
        }

//        public static void main(String[] args) {
//            CrazyBot bot = new CrazyBot();
//            System.out.println(bot.getProbability(1, 25, 25, 25, 25)); // Expected: 1.0
//            System.out.println(bot.getProbability(2, 25, 25, 25, 25)); // Expected: 0.75
//            System.out.println(bot.getProbability(7, 50, 0, 0, 50)); // Expected: 1.0
//            System.out.println(bot.getProbability(14, 50, 50, 0, 0)); // Expected: 1.220703125E-4
//            System.out.println(bot.getProbability(14, 25, 25, 25, 25)); // Expected: 0.008845493197441101
//        }

}
