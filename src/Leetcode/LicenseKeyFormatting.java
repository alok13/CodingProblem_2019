package Leetcode;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String test="2-5g-3-J";
        int k=2;
        String result=findResult(test,k);
        System.out.println(result);
    }

    private static String findResult(String test, int k) {
        String noDashString=test.replaceAll("-","");
        noDashString=noDashString.toUpperCase();
        int first=noDashString.length()%k;
        String result=noDashString.substring(0,first);

        String dash="-";
        for(int i=first;i<noDashString.length();i=i+k){
            if(result.length()>0){
                result=result+dash+noDashString.substring(i,i+k);
            }else {
                result=result+noDashString.substring(i,i+k);
            }

        }
        return result;
    }
}
