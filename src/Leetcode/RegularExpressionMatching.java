package Leetcode;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        String s = "asasas";
        String n = "a*s*asa*";
        boolean result = doesInputMatch(s, n);
        System.out.println(result);
    }

    private static boolean doesInputMatch(String s, String p) {
        boolean[][] arr = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                arr[0][i] = arr[0][i - 2];
            }
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(i) == '.') {
                    arr[i][j] = arr[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    arr[i][j] = arr[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i-1)) {
                        arr[i][j] = arr[i][j] | arr[i - 1][j];
                    }
                }else{
                    arr[i][j]=false;
                }

            }
        }

        return arr[s.length()][p.length()];
    }
}
