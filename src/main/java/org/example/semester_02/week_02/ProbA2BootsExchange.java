package org.example.semester_02.week_02;

import java.util.ArrayList;
import java.util.List;

public class ProbA2BootsExchange {
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
