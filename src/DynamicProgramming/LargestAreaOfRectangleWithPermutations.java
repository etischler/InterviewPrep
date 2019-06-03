package DynamicProgramming;

public class LargestAreaOfRectangleWithPermutations {

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("0"));
    }

    static int numDecodings(String A) {
        if(A.compareTo("0") == 0)
            return 0;
        char[] digits = A.toCharArray();
        return util(digits, A.length());

    }

    private static int util(char[] digits, int n) {

        if (n == 0 || n == 1)
            return 1;

        // Initialize count
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = util(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] == '1' ||
                (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += util(digits, n - 2);

        return count;
    }
}
