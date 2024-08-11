package org.example.semester_02.week_02;

import java.util.ArrayList;
import java.util.List;

public class ProbB2Snowtorm {
    public int blockedLength(List<Integer> startPoints, List<Integer> endPoints) {
        List<int[]> segments = new ArrayList<>();

        for (int i = 0; i < startPoints.size(); i++) {
            segments.add(new int[]{startPoints.get(i), endPoints.get(i)});
        }

        segments.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int totalLength = 0;
        int[] currentSegment = segments.get(0);

        for (int i = 1; i < segments.size(); i++) {
            int[] nextSegment = segments.get(i);
            if (nextSegment[0] <= currentSegment[1]) {
                currentSegment[1] = Math.max(currentSegment[1], nextSegment[1]);
            } else {
                totalLength += currentSegment[1] - currentSegment[0];
                currentSegment = nextSegment;
            }
        }
        totalLength += currentSegment[1] - currentSegment[0];
        return totalLength;
    }

}
