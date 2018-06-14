package Strings;

public class PalindromeString {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome(".,"));
        System.out.println(isPalindrome("1a2"));
    }

    static int isPalindrome(String A) {

        A = A.replaceAll("[^A-Za-z0-9]+", "").toUpperCase();

        StringBuilder stringBuilder = new StringBuilder(A);

        return A.equals(stringBuilder.reverse().toString()) ? 1 : 0;
    }
}
