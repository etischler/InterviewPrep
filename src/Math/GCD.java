package Math;

public class GCD {

    public static void main(String[] args) {
        System.out.println(solution(1701,3768));
    }

    static int solution(int a, int b) {
        while(b % a != 0) {
            int btemp = b;
            b = a;
            a = btemp % a;
        }
        return a;
    }
}
