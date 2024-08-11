package org.example.semester_02.week_03.assignement.block1;

public class SquareOfDigits {
        public static void main(String[] args) {
            System.out.println(getMax(new String[]{"12", "34"}));
//            System.out.println(getMax(new String[]{"1255", "3455"}));
        }

        public static int getMax(String[] data) {
            int maxSquareSize = 1;
            int rows = data.length;
            int cols = data[0].length();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    for (int size = 1; i + size < rows && j + size < cols; size++) {
                        char topLeft = data[i].charAt(j);
                        char topRight = data[i].charAt(j + size);
                        char bottomLeft = data[i + size].charAt(j);
                        char bottomRight = data[i + size].charAt(j + size);

                        if (topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight) {
                            int squareSize = (size + 1) * (size + 1);
                            maxSquareSize = Math.max(maxSquareSize, squareSize);
                        }
                    }
                }
            }

            return maxSquareSize;
        }

}
