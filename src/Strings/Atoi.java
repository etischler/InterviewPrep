package Strings;

public class Atoi {

    public static void main(String[] args) {
        System.out.println(atoi("9 2704"));
        System.out.println(atoi("-88297 248252140B12 37239U4622733246I218 9 1303 44 A83793H3G2 1674443R591 4368 7 97"));
        System.out.println(atoi("- 5 88C340185Q 71 8079 834617385 2898422X5297Z6900"));
        System.out.println(atoi("V515V 5793K 627 23815945269 1 1249794L 631 8755 7"));
        System.out.println(atoi("+7"));
        System.out.println(atoi("+ 3611156"));
    }

    static int atoi(final String A) {
        if (A == null || A.length() < 1)
            return 0;

        // trim white spaces
        String str = A.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }
}
