package agoda;

public class Test3 {
    public static void main(String[] args) {
        String s="SOSSPSSQSSOR";
        int result=marsExploration(s);
        System.out.println(result);
    }

    static int marsExploration(String s) {
        int count=0;
        for(int i=0;i<s.length();i=i+3){
            String sub=s.substring(i,i+3);
           if(!sub.equals("SOS")){
               for(int j=0;j<sub.length();j++){

                   if(sub.charAt(j)!="SOS".charAt(j))
                       count++;
               }
           }
        }
        return count;
    }
}
