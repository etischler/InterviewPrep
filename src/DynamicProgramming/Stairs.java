package DynamicProgramming;

public class Stairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(3));
    }

    static int climbStairs(int A) {
        int[] stairCount = new int[A + 1];

        stairCount[0] = 1;
        stairCount[1] = 2;
        for(int i = 2; i < A; i++)
            stairCount[i] = stairCount[i-1] + stairCount[i-2];
        return stairCount[A - 1];
    }
}
