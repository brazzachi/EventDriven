package org.example;

import org.example.semester_02.week_03.practice.BruteForce;
import org.example.semester_02.week_03.practice.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {


//        Week 03 practice

        BruteForce bruteForce = new BruteForce();
//        bruteForce.findNumberByBruteForceWay(new int[]{1,2,3,4}, 3);

        Recursion recursion = new Recursion();
        int number = 5;
        int result = recursion.factorial(number);
        System.out.println("Factorial of " + number + " is " + result);





        App ins = new App();

        SecondChild secondChild = ins.new SecondChild();

        BootExchange bootExchange = ins.new BootExchange();

//        System.out.println(bootExchange.lestAmount(new int[]{1,3},new int[]{2,2}));

//        System.out.println(secondChild.chooseName("Mohammad Reza", "Yasaman Sadat", "Baqer Ali", "Boy")); // Should return "Mohammad Ali"
//        System.out.println(secondChild.chooseName("Mohammad Reza", "Yasaman Sadat", "Baqer Ali", "Girl")); // Should return "Sadat Yasaman"
//        System.out.println(secondChild.chooseName("Mohammad Reza", "Yasaman Sadat", "Yasaman Ali", "Boy")); // Should return "Mohammad Ali"
//        System.out.println(secondChild.chooseName("Mohammad Reza", "Yasaman Sadat", "Yasaman Ali", "Girl")); // Should return "Yasaman Ali"

        SlowKeyboard sk = ins.new SlowKeyboard();
//        System.out.println(sk.enterTime("59:56")); // 4
//        System.out.println(sk.enterTime("59:59")); // 6
//        System.out.println(sk.enterTime("33:12")); // 8
//        System.out.println(sk.enterTime("16:35")); // 9

        Snowstorm ss = ins.new Snowstorm();

//        List<Integer> startPoints1 = Arrays.asList(17, 85, 57);
//        List<Integer> endPoints1 = Arrays.asList(33, 86, 84);
//        System.out.println(ss.blockedLength(startPoints1, endPoints1)); // Should return 44
//
//        List<Integer> startPoints2 = Arrays.asList(45, 100, 125, 10, 15, 35, 30, 9);
//        List<Integer> endPoints2 = Arrays.asList(46, 200, 175, 20, 25, 45, 40, 10);
//        System.out.println(ss.blockedLength(startPoints2, endPoints2)); // Should return 132
//
//        List<Integer> startPoints3 = Arrays.asList(4387, 711, 2510, 1001, 4687, 3400, 5254, 584, 284, 1423, 3755, 929, 2154, 5719, 1326, 2368, 554);
//        List<Integer> endPoints3 = Arrays.asList(7890, 5075, 2600, 6867, 7860, 9789, 6422, 5002, 4180, 7086, 8615, 9832, 4169, 7188, 9975, 8690, 1423);
//        System.out.println(ss.blockedLength(startPoints3, endPoints3)); // Should return 9691
//
//        List<Integer> startPoints4 = Arrays.asList(12906, 5601, 5087, 1020, 4362, 2657, 6257, 5509, 5107, 5315, 277, 6801, 2136, 2921, 5);
//        List<Integer> endPoints4 = Arrays.asList(233, 5082, 497, 8250, 3956, 5720);
//        System.out.println(ss.blockedLength(startPoints4, endPoints4)); // Should return 10111

    }

    public class SecondChild {

        public String chooseName(String Father, String Mather, String Child1, String Gender) {
            String[] fatherNames = Father.split(" ");
            String[] motherNames = Mather.split(" ");
            String[] child1Names = Child1.split(" ");

            boolean isChild1Female = isFemale(child1Names[0]);
            boolean isSecondChildFemale = Gender.equals("Girl");

            if (isChild1Female != isSecondChildFemale) {
                if (isSecondChildFemale) {
                    return reverseOrder(motherNames);
                } else {
                    return reverseOrder(fatherNames);
                }
            } else {
                if (isSecondChildFemale) {
                    return motherNames[0] + " " + child1Names[1];
                } else {
                    return fatherNames[0] + " " + child1Names[1];
                }
            }
        }

        private boolean isFemale(String firstName) {
            char firstLetter = Character.toUpperCase(firstName.charAt(0));
            return firstLetter == 'A' || firstLetter == 'E' || firstLetter == 'I' || firstLetter == 'O' || firstLetter == 'U' || firstLetter == 'Y';
        }

        private String reverseOrder(String[] names) {
            return names[1] + " " + names[0];
        }

    }

    //

    public class SlowKeyboard {
        public int enterTime(String time) {
            int minutes = Integer.parseInt(time.substring(0, 2));
            int seconds = Integer.parseInt(time.substring(3, 5));

            // Total seconds elapsed since 00:00
            int totalSeconds = minutes * 60 + seconds;

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

    public class BootExchange{
        public int lestAmount(int [] left, int [] right){

            if (left.length == right.length) {
                List<Integer> rightList = new ArrayList<>();
                for (int num : right) {
                    rightList.add(num);
                }

                int count = 0;
                for (int i : left) {
                    for (int j = 0; j < rightList.size(); j++) {
                        int i1 = rightList.get(j);
                        System.out.println(i + "--" + i1);
                        if (i == i1) {
                            count++;
                            rightList.remove(j);
                            break;
                        }
                    }
                }
                return left.length - count;
            } else {
                return -1;
            }
        }
    }

    public class Snowstorm {
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
}



