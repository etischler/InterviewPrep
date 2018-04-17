package Arrays;

import java.util.ArrayList;

public class FindPermutation {

    public static void main(String[] args) {
        System.out.println(findPerm("ID", 3));
        System.out.println(findPerm("DIDID", 6));
    }

    static ArrayList<Integer> findPerm(final String A, int B) {

        if(!(A.length() == B - 1))
            return new ArrayList<>();

        int top = B;
        int bottom = 1;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == 'D') {
                ans.add(top);
                top--;
            }
            else if(A.charAt(i) == 'I') {
                ans.add(bottom);
                bottom++;
            }
        }
        ans.add(top);

        return ans;
    }
}
