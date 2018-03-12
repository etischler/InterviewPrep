package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class KthRowOfPascalsTriangle {

    public static void main(String[] args) {

        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(3));

    }

    static ArrayList<Integer> getRow(int A) {
        A++;
        ArrayList<ArrayList<Integer>> R = new ArrayList<>();
        for(int i = 0; i < A; i++)
        {
            ArrayList<Integer> a = new ArrayList<>();
            for(int j = 0; j < i + 1; j++)
            {
                if(j == 0)
                {
                    a.add(1);
                }
                else
                {
                    int newAdd = 0;
                    if(j - 1 < R.get(i - 1).size())
                        newAdd += R.get(i - 1).get(j - 1);
                    if(j < R.get(i - 1).size())
                        newAdd += R.get(i - 1).get(j);
                    a.add(newAdd);
                }
            }
            R.add(a);
        }
        return R.get(R.size() - 1);
    }
}
