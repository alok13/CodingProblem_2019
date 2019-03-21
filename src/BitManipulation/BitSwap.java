package BitManipulation;

public class BitSwap {
    public static void main(String args[]){
        int i=13;
        int pos1=2;
        int pos5=5;
        int result=swap(i,pos1,pos5);
        System.out.println(result);
    }

    public static int swap(int i, int pos1, int pos2) {

        int bit1 = (i >> pos1) & 1;// bit at pos1
        int bit2 = (i >> pos2) & 1;// bit at pos2

        if (bit1 == bit2)
            return i; // no need to swap since we change 1 with 1 or 0 with 0

        // Since we are here it means that we need to change 1->0 and 0->1.
        // To do this we can use XOR (^).
        // Lets create mask 000001010 with ones at specified positions
        int mask = (1 << pos1) | (1 << pos2);

        return i ^ mask;// TADAM!!!
    }
}
