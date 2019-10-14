package Leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/different-ways-to-add-parentheses/
public class CalculatePossibleSoutions {
    public static void main(String[] args) {
        String test = "2*3-4*5";
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> results = getSum(test, map);
        for (int i : results)
            System.out.println(i);
    }


    private static List<Integer> getSum(String test, Map<String, List<Integer>> map) {
        if (map.containsKey(test))
            return map.get(test);
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < test.length(); i++) {
            if (test.charAt(i) == '-' || test.charAt(i) == '*' || test.charAt(i) == '+') {
                String firstPart = test.substring(0, i);
                String secondPart = test.substring(i + 1);
                List<Integer> firstSum = getSum(firstPart, map);
                List<Integer> secondSum = getSum(secondPart, map);
                for (Integer p1 : firstSum) {
                    for (Integer p2 : secondSum) {
                        switch (test.charAt(i)) {
                            case '+':
                                sum = p1 + p2;
                                break;
                            case '-':
                                sum = p1 - p2;
                                break;
                            case '*':
                                sum = p1 * p2;
                                break;
                        }
                        result.add(sum);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(test));
        }
        map.put(test, result);
        return result;
    }
}
