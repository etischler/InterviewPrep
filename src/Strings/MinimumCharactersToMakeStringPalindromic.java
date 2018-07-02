package Strings;

public class MinimumCharactersToMakeStringPalindromic {

    public static void main(String[] args) {
        System.out.println(solve("ABC"));
        System.out.println(solve("AACECAAAA"));
        System.out.println(solve("pggxrpnrvystmwcysyy"));
    }

    static int solve(String A) {

        int numOff = 0;

        while(A.length() > 0){
            if(A.equals(new StringBuilder(A).reverse().toString()))
                break;
            else
                numOff++;
            A = A.substring(0, A.length() - 1);
        }
        return numOff;
    }
}
