package org.example.semester_02.week_03.lectureOfRecursion;

    public class Permutations {
        public static void printPerm(String s) {
            boolean[] used = new boolean[s.length()];
            char[] in = s.toCharArray();
            char[] out = new char[s.length()];
            permute(in, out, used, 0, s.length());
        }

        private static void permute(char[] in, char[] out, boolean[] used, int depth, int length) {
            if (depth == length) {
                System.out.println(new String(out));
                return;
            }

            for (int i = 0; i < length; i++) {
                if (used[i]) continue;
                used[i] = true;
                out[depth] = in[i];
                permute(in, out, used, depth + 1, length);
                used[i] = false; // backtrack
            }
        }
//
//        public static void main(String[] args) {
//            printPerm("abc");
//        }


//        Version of Recursive
public static void printPermWithRecursive(String s) {
    permute("", s);
}
private static void permute(String prefix, String remaining) {
    int n = remaining.length();
    if (n == 0) {
        System.out.println(prefix);
    } else {
        for (int i = 0; i < n; i++) {
            permute(prefix + remaining.charAt(i),
                    remaining.substring(0, i) + remaining.substring(i + 1, n));
        }
    }
}

//        public static void main(String[] args) {
//            printPerm("abc");
//        }
//
}
