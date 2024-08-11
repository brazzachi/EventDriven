package org.example.semester_02.week_03.assignement.block1;

import java.util.ArrayList;
import java.util.List;

public class MooningCows {

        public static void main(String[] args) {
            System.out.println(dissatisfaction(new String[]{"C..", ".C.", ".C."})); // Should return 3
            System.out.println(dissatisfaction(new String[]{"CCCC", "CCCC", "CCCC"})); // Should return 26
            System.out.println(dissatisfaction(new String[]{"C"})); // Should return 0

        }

        public static int dissatisfaction(String[] farmland) {
            int n = farmland.length;
            int m = farmland[0].length();
            List<int[]> cowPositions = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (farmland[i].charAt(j) == 'C') {
                        cowPositions.add(new int[]{i, j});
                    }
                }
            }

            int minDissatisfaction = Integer.MAX_VALUE;

            for (int[] mooingCow : cowPositions) {
                int currentDissatisfaction = 0;
                for (int[] cow : cowPositions) {
                    if (mooingCow != cow) {
                        int dx = mooingCow[0] - cow[0];
                        int dy = mooingCow[1] - cow[1];
                        currentDissatisfaction += dx * dx + dy * dy;
                    }
                }
                minDissatisfaction = Math.min(minDissatisfaction, currentDissatisfaction);
            }

            return minDissatisfaction;
        }

}
