package DynamicProgramming;

public class TripleStep {

    public static void main(String[] args) {
        System.out.println(topDown(4));
        System.out.println(topDownMemoized(4, new int[5]));
        System.out.println(bottomUp(4));
        System.out.println(constantMem(4));
    }

    //top-down approach
    static int topDown(int n) {
        if(n <= 0)
            return 0;
        else if(n <= 2)
            return n;
        else if(n == 3)
            return 4;

        return topDown(n-1) + topDown(n-2) + topDown(n-3);
    }

    static int topDownMemoized(int n, int[] memo) {
        if(memo[n] != 0)
            return memo[n];
        if(n <= 0)
            return 0;
        else if(n <= 2)
            return n;
        else if(n == 3)
            return 4;

        memo[n] = topDownMemoized(n-1, memo) + topDownMemoized(n-2, memo) + topDownMemoized(n-3, memo);
        return memo[n];
    }

    //bottom-up approach
    static int bottomUp(int n){
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        for(int i = 4; i <= n; i++){
            memo[i] = memo[i-3] + memo[i-2] + memo[i-1];
        }
        return memo[n];
    }

    static int constantMem(int n){
        if(n <= 0)
            return 0;
        else if(n <= 2)
            return n;
        else if(n == 3)
            return 4;
        int a = 1;
        int b = 2;
        int c = 4;
        int newC;
        for(int i = 4; i <= n; i++){
            newC = a + b + c;
            a = b;
            b = c;
            c = newC;
        }
        return c;
    }

}
