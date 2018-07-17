package Strings;

import java.math.BigInteger;

public class AddBinaryStrings {

    public static void main(String[] args) {
        System.out.println(addBinary("100", "11"));
    }

    static String addBinary(String A, String B) {
        BigInteger num1 = new BigInteger(A, 2);
        BigInteger num2 = new BigInteger(B, 2);
        return num1.add(num2).toString(2);



    }
}
