package DynamicProgramming;

public class Stairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    static int climbStairs(int A) {
        if(A <= 1)
            return 1;
        return climbStairs(A - 1) + climbStairs(A - 2);
    }
}
