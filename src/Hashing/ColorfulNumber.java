package Hashing;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {

    public static void main(String[] args) {
        System.out.println(colorful(263));
        System.out.println(colorful(23));
        System.out.println(colorful(99));
        System.out.println(colorful(123456789));
    }

    static int colorful(int A) {
        String str = Integer.toString(A);
        Set<Character> duplicateCheck = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(duplicateCheck.contains(c))
                return 0;
            else
                duplicateCheck.add(c);
        }

        Set<String> st = new HashSet<>();
        subsequence(str, st);
        Set<Integer> valueSet = new HashSet<>();
        for(String num : st){
            int curr = Character.getNumericValue(num.charAt(0));
            for(int i = 1; i < num.length(); i++){
                curr *= Character.getNumericValue(num.charAt(i));
            }
            if(valueSet.contains(curr))
                return 0;
            else
                valueSet.add(curr);
        }


        return 1;
    }


    static void subsequence(String str, Set<String> st)
    {
        for (int i = 0; i < str.length(); i++)
        {
            // j is the number of elements which should be printed
            for (int j = i; j < str.length(); j++)
            {
                // print the array from i to j
                StringBuilder builder = new StringBuilder();
                for (int k = i; k <= j; k++)
                {
                    builder.append(str.charAt(k));
                }
                st.add(builder.toString());
                //System.out.println();
            }
        }
    }
}
