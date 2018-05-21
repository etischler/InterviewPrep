package Math;

public class PowerOfTwoIntegers {

    public static void main(String[] args) {
        System.out.println(isPower(6));
    }

    public static int isPower(int A) {
        double sqrtA = Math.sqrt(A);
        for(int i = (int) sqrtA; i >=2; i--) {
            int a = A;
            while(a % i == 0){
                if(a == i)
                    return 1;
                a /= i;
            }
        }
        return 0;
    }
}
