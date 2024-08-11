package org.example.semester_02.week_02;

public class ProbB1SlowKeyBoard {
    public int enterTime(String time) {   // 4:26
        int minutes = Integer.parseInt(time.substring(0, 2)); //4
        int seconds = Integer.parseInt(time.substring(3, 5));//26

        // Total seconds elapsed since 00:00
        int totalSeconds = minutes * 60 + seconds; //240 + 26 = 266

        // Find the minimum time to open the door
        int minTime = Integer.MAX_VALUE;

        for (int min = 0; min < 60; min++) {
            for (int sec = 0; sec < 60; sec++) {
                int currentSeconds = min * 60 + sec;
                int waitTime = (currentSeconds - totalSeconds + 3600) % 3600;

                String timeString = String.format("%02d%02d", min, sec);
                int pressTime = calculateTime(timeString);

                minTime = Math.min(minTime, pressTime + waitTime);
            }
        }

        return minTime;
    }
        private int calculateTime(String time) {
            int timeTaken = 0;
            for (int i = 0; i < time.length(); i++) {
                timeTaken++;
                if (i > 0 && time.charAt(i) != time.charAt(i - 1)) {
                    timeTaken += 2;
                }
            }
            return timeTaken;
        }
}
