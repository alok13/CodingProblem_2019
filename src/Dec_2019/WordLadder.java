package Dec_2019;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        List<String> result = new ArrayList<String>();

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            if (currentWord.equals(endWord)) {
                result.forEach(System.out::println);
                continue;
            }
            char[] wordArray = currentWord.toCharArray();
            boolean found = false;
            for (int i = 0; i < wordArray.length; i++) {
                found = false;
                for (char j = 'a'; j <= 'z'; j++) {
                    char temp = wordArray[i];
                    if (wordArray[i] != j) {
                        wordArray[i] = j;
                    }
                    String newWord = new String(wordArray);
                    if (wordSet.contains(newWord)) {
                        wordSet.remove(newWord);
                        queue.add(newWord);
                        found = true;

                    }
                    wordArray[i] = temp;
                }
                if (found) {
                    result.add(currentWord);
                    count++;

                }
            }

            System.out.println("================");
        }


        System.out.println();
        return 0;
    }
}
