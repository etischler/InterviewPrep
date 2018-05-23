package Math;

public class ExcelColumnTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(257));
        System.out.println(convertToTitle(676));
        System.out.println(convertToTitle(1000));
    }

    public static String convertToTitle(int A) {
        String ans = "";
        while(A > 0) {
           int remainder = A % 26;

           if(remainder == 0) {
               ans += 'Z';
               A = (A / 26) - 1;
           }
           else{
               ans += (char) ('@' + remainder);
               A /= 26;
           }
        }

        return new StringBuilder(ans).reverse().toString();
    }
}
