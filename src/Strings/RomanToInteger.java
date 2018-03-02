package Strings;

import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("XIV"));
        System.out.println(romanToInt("XX"));
        System.out.println(romanToInt("MDCCLXXVI"));
        System.out.println(romanToInt("MCMLIV"));
        System.out.println(romanToInt("MCMXC"));
        System.out.println(romanToInt("MMXIV"));
        System.out.println(romanToInt("V"));

    }

    public static int romanToInt(String A) {
        int ans = 0;
        int subset = 0;
        HashMap<Character, Integer> valueMap = new HashMap();
        valueMap.put('M' , 1000);
        valueMap.put('D' , 500);
        valueMap.put('C' , 100);
        valueMap.put('L', 50);
        valueMap.put('X', 10);
        valueMap.put('V', 5);
        valueMap.put('I', 1);

        for(int i = 0; i < A.length(); i++) {
            if(i + 1 < A.length()) {
                if(A.charAt(i+1) == A.charAt(i))
                    subset += valueMap.get(A.charAt(i));
                else if(valueMap.get(A.charAt(i+1)) > valueMap.get(A.charAt(i))) {
                    subset += valueMap.get(A.charAt(i));
                    i++;
                    ans += valueMap.get(A.charAt(i)) - subset;
                    subset = 0;
                    continue;
                }
                else {
                    ans += valueMap.get(A.charAt(i)) + subset;
                    subset = 0;
                }
            }
            if(i - 1 >= 0 && i == A.length() - 1) {
                if(A.charAt(i - 1) == A.charAt(i)) {
                    ans += valueMap.get(A.charAt(i)) + subset;
                    subset = 0;
                }
                else {
                    ans += valueMap.get(A.charAt(i)) - subset;
                }
            }
        }

        return A.length() != 1 ? ans : valueMap.get(A.charAt(0));
    }
}
