package Older;

import java.util.ArrayList;
import java.util.List;

public class Bracket {
    public static void main(String[] args) {
       String test="(())(";
        List<Character>  list=new ArrayList<>();
        for(int i=0;i<test.length();i++){
            if(test.charAt(i)=='('){
                list.add('(');
            }else{
                if(list.contains('(')){
                    list.remove(list.indexOf('('));
                }else{
                    list.add(')');
                }
            }
        }

        System.out.println(list.size());

    }
}
