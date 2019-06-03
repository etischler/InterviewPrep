package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyStocksII {

    public static void main(String[] args) {
        System.out.println(maxProfit(new ArrayList<>(Arrays.asList(1, 2, 3))));
    }

    static int maxProfit(final List<Integer> A) {
        int profit = 0;
        for(int i=1; i<A.size(); i++){
            int diff = A.get(i)-A.get(i-1);
            if(diff > 0){
                profit += diff;
            }
        }
        return profit;
    }
}
