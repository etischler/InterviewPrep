package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A1 = new ArrayList<>();
        A1.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        A1.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        A1.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

      rotate(A1);

    }

    private static void printArray(ArrayList<ArrayList<Integer>> A1) {
        for(int i = 0; i < A1.size(); i++){
            if(i!=0)
                System.out.print("\n");
            for(int j = 0; j < A1.get(0).size(); j++) {
                System.out.print(A1.get(i).get(j));
                if(j != A1.get(i).size() - 1)
                    System.out.print(", ");
            }
        }
    }

    public static void rotate(ArrayList<ArrayList<Integer>> a) {

        transpose(a);

        reverseRows(a);

        printArray(a);

    }

    private static void reverseRows(ArrayList<ArrayList<Integer>> a) {

        for(int i = 0; i < a.size(); i++) {
            int start = 0;
            int end = a.get(i).size() - 1;
            while(end - start > 0) {
                int temp = a.get(i).get(end);
                a.get(i).set(end, a.get(i).get(start));
                a.get(i).set(start, temp);
                start++;
                end--;
            }
        }

    }

    private static void transpose(ArrayList<ArrayList<Integer>> a) {

        for(int i = 0; i < a.size(); i++) {
            for(int j = i; j < a.get(0).size(); j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, (a.get(j).get(i)));
                a.get(j).set(i, temp);
            }
        }

    }
}
