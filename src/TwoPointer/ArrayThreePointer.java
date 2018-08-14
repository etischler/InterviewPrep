package TwoPointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayThreePointer {

    public static void main(String[] args) {
        System.out.println(minimize(new LinkedList<>(Arrays.asList(1,4,10)),new LinkedList<>(Arrays.asList(2,15,20)),new LinkedList<>(Arrays.asList(10,12))));
    }

    static int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int diff = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int k = 0;
        int p = A.size();
        int q = B.size();
        int r = C.size();

        while (i<p && j<q && k<r) {

            int maximum = Math.max(Math.abs(A.get(i) - B.get(j)), Math.max(Math.abs(B.get(j) - C.get(k)), Math.abs(C.get(k) - A.get(i))));

            if(maximum < diff)
                diff = maximum;

            if(diff == 0) break;

            if(maximum == Math.abs(A.get(i) - B.get(j))) {
                if(i+1 < p && j+1 < q){
                    if(Math.abs(A.get(i+1) - B.get(j)) < Math.abs(A.get(i) - B.get(j+1)) ) {
                        i++;
                    }
                    else
                        j++;
                }
                else if(i+1 < p){
                    i++;
                }
                else
                    j++;

            }

            else if(maximum == Math.abs(B.get(j) - C.get(k))) {
                if(j+1 < q && k+1 < r) {
                    if (Math.abs(B.get(j + 1) - C.get(k)) < Math.abs(B.get(j) - C.get(k + 1))) {
                        j++;
                    } else
                        k++;
                }
                else if(j+1 < q)
                    j++;
                else
                    k++;
            }

            else if(maximum == Math.abs(C.get(k) - A.get(i))) {
                if(k+1 < r && i+1<p) {
                    if (Math.abs(C.get(k + 1) - A.get(i)) < Math.abs(C.get(k) - A.get(i + 1))) {
                        k++;
                    } else
                        i++;
                }
                else if(k+1 < r)
                    k++;
                else
                    i++;
            }
            else
                System.out.println("error");


        }

        return diff;
    }
}
