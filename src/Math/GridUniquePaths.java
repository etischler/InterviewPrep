package Math;

import java.math.BigInteger;

public class GridUniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
        System.out.println(uniquePaths(15,9));

    }

    /*
    Number of possiblities / (possibilities of a * possibilities of b)
    (a+b)! / (a!b!)
     */
    static int uniquePaths(int A, int B) {
        if(A == 1 || B == 1)
            return 1;
        A-=1;
        B-=1;
        BigInteger a = BigInteger.valueOf(A);
        BigInteger b = BigInteger.valueOf(B);

        return ( (factorial(a.add(b))) .divide(factorial(a).multiply(factorial(b)))).intValue();

    }
    static BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) == 0)
            return BigInteger.valueOf(1);

        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
