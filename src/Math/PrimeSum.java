package Math;

import java.util.ArrayList;

public class PrimeSum {

    public static void main(String[] args) {
        primesum(16777214).forEach(val -> System.out.println(val + " "));
    }

    private static ArrayList<Integer> primesum(int A) {

        boolean prime[] = new boolean[A+1];
        for(int i=0;i<A;i++)
            prime[i] = true;

        for(int p = 2; p*p <=A; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p])
            {
                // Update all multiples of p
                for(int i = p*2; i <= A; i += p)
                    prime[i] = false;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        // Print all prime numbers
        for(int i = 2; i <= A; i++)
        {
            if(prime[i] && prime[A - i]) {
                ans.add(i);
                ans.add(A - i);
                break;
            }
        }
        return ans;
    }
}
