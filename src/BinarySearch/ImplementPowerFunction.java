package BinarySearch;

import java.math.BigInteger;

public class ImplementPowerFunction {

    public static void main(String[] args) {
        System.out.println(pow(2, 3, 3));
        System.out.println(pow(-1, 1, 20));
        System.out.println(pow(71045970, 41535484, 64735492));
    }

    static int pow(int x, int n, int d) {
        long pow = power((long) x, (long) n);

        while(pow < 0) {
            pow += d;
        }

        return BigInteger.valueOf(pow).mod(BigInteger.valueOf((long)d)).intValue();
    }

    static long power(long x, long y)
    {
        long temp;
        if( y == 0)
            return 1L;
        temp = power(x, BigInteger.valueOf(y).divide(BigInteger.valueOf(2)).longValue());

        if (y%2 == 0)
            return temp*temp;
        else
        {
            if(y > 0)
                return x * temp * temp;
            else
                return BigInteger.valueOf(temp * temp).divide(BigInteger.valueOf(x)).longValue();
        }
    }
}
