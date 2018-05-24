package Math;

public class LargestCoPrimeDivisor {

    public static void main(String[] args) {
        System.out.println(cpFact(30, 12));
        System.out.println(cpFact(2, 2));
    }

    static int cpFact(int A, int B) {
        while (getGCD(A, B) != 1) {
            A = A / getGCD(A, B);
        }
        return A;
    }


    static int getGCD(int a, int b) {
        while(b % a != 0) {
            int btemp = b;
            b = a;
            a = btemp % a;
        }
        return a;
    }
}
