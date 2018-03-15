package Math;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(12121));
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(9));

    }

    /*
        Reverse integer, store in a different variable
        compare to orignal integer for return value
     */

    static int isPalindrome(int A) {

        int reverse = 0;
        int toZero = A;
        while(toZero > 0) {
            reverse *= 10;
            reverse += toZero % 10;
            toZero /= 10;
        }
        return A == reverse ? 1 : 0;
    }
}
