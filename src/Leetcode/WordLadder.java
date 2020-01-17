package LeetCode;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String[] list={"hot","dot","dog","lot","log","cog"};
        //String[] list={"hot","dot","dog","lot","log"};
        List<String> wordList= Arrays.asList(list);
        String beginWord="hit";
        String endWord="cog";
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        LinkedList<WordNode> queue=new LinkedList<>();
        //wordSet.add(endWord);
        queue.add(new WordNode(beginWord,1));

        while(!queue.isEmpty()){
            WordNode top=queue.remove();
            String topWord=top.word;

            if(topWord.contains(endWord))
                return top.numSteps;

            char[] arr=topWord.toCharArray();

            for(int i=0;i<arr.length;i++){
                for(char c='a';c<='z';c++){
                    char temp=arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
                    String newWord=new String(arr);
                    if(wordSet.contains(newWord)){
                        System.out.println(newWord);
                            queue.add(new WordNode(newWord,top.numSteps+1));
                            wordSet.remove(newWord);
                    }
                    arr[i]=temp;
                }
            }
        }
        return 0;
    }
}


class WordNode{
    String word;
    int numSteps;

    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}
