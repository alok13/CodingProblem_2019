package HackerRank;

import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        //Hi, Hello, Hey, Hi, Hello, Hey]
        list.add("Hello");
        list.add("Hi");
        list.add("Hey");
        list.add("Hello");
        list.add("Hi");
        list.add("Hey");

        ArrayList<String> result=removeDuplicates(list);
        System.out.println();
    }

    public static ArrayList<String> removeDuplicates(List<String> input) {
        Set<String> unique=new LinkedHashSet<>();
        for(int i=0;i<input.size();i++){
            unique.add(input.get(i));
        }
        Iterator<String> iterator=unique.iterator();
        ArrayList<String> list= new ArrayList<String>(unique);


        return list;

    }
}


