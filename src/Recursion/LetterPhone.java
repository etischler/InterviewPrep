package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterPhone {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static ArrayList<String> letterCombinations(String A) {

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('0',Arrays.asList('0'));
        map.put('1',Arrays.asList('1'));
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));

        ArrayList<String> ans = new ArrayList<>();


        StringBuilder curr = new StringBuilder("");

        util(A, map, ans, curr, 0);

        return ans;
    }

    private static void util(String A, Map<Character, List<Character>> map, ArrayList<String> ans, StringBuilder curr, int start) {
        if(start >= A.length()) {
            ans.add(curr.toString());
            return;
        }
        for(Character character : map.get(A.charAt(start))){
            curr.append(character);

            util(A, map, ans, curr, start + 1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
