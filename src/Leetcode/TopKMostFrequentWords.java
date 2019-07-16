package Leetcode;

import java.util.*;

public class TopKMostFrequentWords {
    public static void main(String[] args) {
        String [] arr= {"i", "love", "leetcode", "i", "love", "coding"};
        int k=2;
        List<String> result=findFrequentNumber(arr,k);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }



    private static List<String> findFrequentNumber(String[] arr, int k) {
        Map<String,Integer> countMap=new HashMap<>();
        for(int i=0;i<arr.length;i++){
           int count= countMap.getOrDefault(arr[i],1);
           countMap.put(arr[i],count+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue=new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        //get all elements from the heap
        List<String> result = new ArrayList<>();
        while (queue.size() > 0) {
            result.add(queue.poll().getKey());
        }
        Collections.reverse(result);
        return result;

    }
}


