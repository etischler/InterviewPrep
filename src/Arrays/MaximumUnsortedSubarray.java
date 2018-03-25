package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumUnsortedSubarray {

    public static void main(String[] args) {

        System.out.println(subUnsort(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5))));
        System.out.println(subUnsort(new ArrayList<>()));
        System.out.println(subUnsort(new ArrayList<>(Arrays.asList(1))));
        //4, 15, 4, 4, 15, 18, 20
        System.out.println(subUnsort(new ArrayList<>(Arrays.asList(4, 15, 4, 4, 15, 18, 20))));
    }

/*
        [1, 3, 2, 4, 5]
        if(a.size==0 || a.size == 1)
            return -1;
        int leftBroken = -1
        int rightBroken = -1
        for left to right:
            if i + 1 < n:
                if leftBroken ==  -1 && a[i+1] < a[i]:
                    leftBroken = i;
                    break;
        if(leftBroken == -1)
            return -1;

        for right to left:
            if i - 1 >= 0:
                if rightBroken == -1 && a[i-1] > a[i]:
                    rightBroken = i;
                    break;

        int min = Int.MAX;
        int max = 0;

        for leftbroken : rightbroken
            min = min(min,A.get(i)
            max = max(max, A.get(i)

        while(rightbroken + 1 < A.size)
            if(max <= A.get(rightBroken + 1))
                break;
            else
                rightBroken++;

        while(leftBroken - 1 > -1)
            if(min >= A.get(leftBroken - 1)
                break;
            leftBroken--;


        Arraylist ans<Integer>
        ans.add(leftBroken)
        ans.add(rightBroken)
        return ans;
 */

    static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {

        if(A.size() == 0 || A.size() == 1)
            return new ArrayList<>(Arrays.asList(-1));

        int leftBroken = -1;
        int rightBroken = -1;

        for(int i = 0; i < A.size(); i++){
            if(i + 1 < A.size() && A.get(i + 1) < A.get(i)){
                leftBroken = i;
                break;
            }
        }
        if(leftBroken == -1)
            return new ArrayList<>(Arrays.asList(-1));

        for(int i = A.size() - 1; i > -1; i--) {
            if( i - 1 > -1 && A.get(i - 1) > A.get(i)){
                rightBroken = i;
                break;
            }
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = leftBroken; i <= rightBroken; i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }

        while(rightBroken + 1 < A.size()) {
            if (max <= A.get(rightBroken + 1))
                break;
            else
                rightBroken++;
        }

        while(leftBroken - 1 > -1) {
            if (min >= A.get(leftBroken - 1))
                break;
            else
                leftBroken--;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(leftBroken);
        ans.add(rightBroken);

        return ans;
    }
}
