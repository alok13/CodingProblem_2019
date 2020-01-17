package Leetcode;

import java.util.*;

// https://leetcode.com/problems/word-ladder-ii/
public class WordLadder_2 {

    static List<String> resultFinal = new ArrayList<>();

    public static void main(String[] args) {

        List<String> wordlist = new ArrayList<>();
        wordlist.add("hot");
        wordlist.add("dot");
        wordlist.add("dog");
        wordlist.add("lot");
        wordlist.add("log");
        wordlist.add("cog");

        String startWord = "hit";
        String endWord = "cog";
        List<List<String>> result = findLadders(startWord, endWord, wordlist);
        for (List<String> l : result) {
            System.out.println("===========");
            for (String s : l) {
                System.out.print(s + "  ");
            }
        }


    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> unvisited = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        Queue<Node_2> queue = new LinkedList<>();
        queue.offer(new Node_2(beginWord, 0, null));
        int minLen = Integer.MAX_VALUE;
        if(!wordList.contains(endWord))
        return result;


        while (!queue.isEmpty()) {
            Node_2 top = queue.poll();
            //top if have shorter result already
            if (result.size() > 0 && top.depth > minLen) {
                return result;
            }
            if (top.value.equals(endWord)) {
                return result;
            }
            for (int i = 0; i < top.value.length(); i++) {
                char c = top.value.charAt(i);
                char[] charArray = top.value.toCharArray();
                for (char c1 = 'z'; c1 >= 'a'; c1--) {
                    if (c1 == c) {
                        continue;
                    }
                    charArray[i] = c1;
                    String newWord = new String(charArray);

                    if (newWord.equals(endWord)) {
                        List<String> aResult = new ArrayList<>();
                        aResult.add(newWord);
                        Node_2 t = top;
                        while (t != null) {
                            aResult.add(t.value);
                            t = t.node;
                        }
                        Collections.reverse(aResult);
                        result.add(aResult);

                        //stop if get shorter result
                        if (top.depth <= minLen) {
                            minLen = top.depth;
                        } else {
                            return result;
                        }

                    }

                    if (unvisited.contains(newWord)) {
                        Node_2 n = new Node_2(newWord, top.depth + 1, top);
                        queue.offer(n);
                        unvisited.remove(newWord);
                    }
                }
            }
        }

        return result;
    }


}

class Node_2 {
    String value;
    int depth;
    Node_2 node;

    public Node_2(String value, int depth, Node_2 node) {
        this.depth = depth;
        this.node = node;
        this.value = value;
    }
}
