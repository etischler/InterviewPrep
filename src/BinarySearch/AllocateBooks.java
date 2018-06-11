package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {

    public static void main(String[] args) {
        System.out.println(books(new ArrayList<>(Arrays.asList(12, 34, 67, 90)), 2));
    }

    static int books(ArrayList<Integer> A, int B) {

        if(A.size() < B)
            return -1;

        int sum = 0;
        for(int a : A)
            sum += a;

        int start = 0;
        int end = sum;
        int mid = (start + end) / 2;
        int ans = Integer.MAX_VALUE;
        while(start <= end) {
            if(isPossible(A,B, mid)){
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else
                start = mid + 1;

            mid = (start + end) / 2;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static boolean isPossible(ArrayList<Integer> A, int B, int mid) {

        int currSum = 0;
        int numStudents = 1;

        for(int a : A){
            if(a > mid)
                return false;
            if(currSum + a > mid) {
                currSum = a;
                numStudents++;
                if(numStudents > B)
                    return false;
            }
            else
                currSum += a;
        }
        return true;
    }
}
