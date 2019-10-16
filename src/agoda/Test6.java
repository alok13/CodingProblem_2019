package agoda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> list1= Arrays.asList(11,2,4);
        List<Integer> list2= Arrays.asList(4,5,6);
        List<Integer> list3= Arrays.asList(10,8,-12);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        int result=getResult(list);
        System.out.println(result);
    }

    private static int getResult(List<List<Integer>> list) {
        int sum1=0;
        int sum2=0;
        for(int i=0;i<list.size();i++){
            sum1=sum1+list.get(i).get(i);
            sum2=sum2+list.get(i).get(list.size()-1-i);
        }
        return Math.abs(sum1-sum2);
    }
}
