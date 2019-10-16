package HackerRank;

public class Test1_Agoda {
    public static void main(String[] args) {
        String s = "saveChangesInTheEditor";
        System.out.println(camelcase(s));
    }

    static int camelcase(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i)))
                count++;
        }
       return  count + 1;
    }
}
