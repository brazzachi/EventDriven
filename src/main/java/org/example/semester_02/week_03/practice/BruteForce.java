package org.example.semester_02.week_03.practice;

import java.util.List;

public class BruteForce {

//    Example one:
//    Find a special number from list

    public static boolean findNumberByBruteForceWay(int [] numberList, int specialNumber){
        for (int i : numberList) {
            int compare = Integer.compare(i, specialNumber);
            // If i is less than specialNumber, it returns -1.
            //If i is equal to specialNumber, it returns 0.
            //If i is greater than specialNumber, it returns 1
            return compare == 0 ? true : false;
        }
        return false;
    };

//    Using a Lambda Expression with Predicate


//    Using Lambda Expressions with Streams

    public static boolean StreamLambdaExampleForFindNumber(List<Integer> list, int number){

      return   list.stream().anyMatch( num -> num == number);

    }



}
