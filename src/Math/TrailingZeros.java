package Math;

public class TrailingZeros {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(3125));
    }

    public static int trailingZeroes(int A) {
        int five = 5;
        int trailingZeros = 0;
        while(five <= A) {
            trailingZeros += A / five;
            five = five * 5;
        }
        return trailingZeros;
    }
}
