package org.example.semester_02.week_03.practice;

public class Recursion {

    // Kama ropitha agaya sewimaz

    public static int factorial(int n) {
            if (n == 0) {
                return 1;
            } else {
                return n * factorial(n - 1);
            }
    }


}
