package NovemberChallenge;

public class Test2 {
    public static void main(String[] args) {
        String test="b";
        String result=getReducedString(test);
        System.out.println(result);
    }

    private static String getReducedString(String test) {
        String result="Empty String";
        int index=isReductionPossible(test);
        if(index>-1){
            StringBuilder sb = new StringBuilder(test);
            sb.deleteCharAt(index);
            sb.deleteCharAt(index);
            String str=new String(sb);
            return getReducedString(str);
        }else {
            if(test==null ||test.isEmpty()){
                return result;
            }else{
                return test;
            }
        }
    }

    private static int isReductionPossible(String test) {
        if(test.length()==2 && test.charAt(0)==test.charAt(1))
            return 0;
        for(int i=0;i<test.length()-2;i++){
            if(test.charAt(i)==test.charAt(i+1))
                return i;
        }
        return -1;
    }

}


