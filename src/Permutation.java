public class Permutation {
    public static void main(String[] args) {
        String test = "abcd";
        getAllPermutation(test, "");
    }

    private static void getAllPermutation(String original, String support) {
        if (original == null)
            return;
        int length = original.length();
        if (length == 0)
            System.out.println(support);
        else {
            for (int i = 0; i < original.length(); i++) {
                String s = original.substring(0, i) + original.substring(i + 1, length);
                String s1 = support + original.charAt(i);
                getAllPermutation(s, s1);
            }
        }


    }
}
