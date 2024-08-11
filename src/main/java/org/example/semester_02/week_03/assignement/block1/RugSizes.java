package org.example.semester_02.week_03.assignement.block1;

public class RugSizes {
    public static void main(String[] args) {
      rugCount(12);
    }

    public static int rugCount(int area){
       return countValidRugs(area,1);
    }

    public static int countValidRugs(int area, int width){
        if(width*width > area) return 0;
        int count = 0;

        if(area%width == 0){
            int l = area/width;
            if (width == l || (width % 2 != 0 || l % 2 != 0)) {
                count = 1;
            }
        }

        return count + countValidRugs(area, width + 1);
    }
}
