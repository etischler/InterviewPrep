package BitManipulation;

public class NumberofOneBits {

    public static void main(String[] args) {
        System.out.println(numSetBits(00000000000000000000000000001011));
    }

    static int numSetBits(long a) {

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((a & (1 << i)) != 0)
                ans++;
        }
        return ans;
    }

}
