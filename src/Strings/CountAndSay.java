package Strings;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
/*
    String currStr = "1"
    for (0 + 1) A:
        int currCount = 0;
        Str newStr = "";
        Char currChar = currStr.charAt(0)
        for currStr:
            if(currChar != currStr.charAt(j))
                newStr += currCount + currChar
                currCount = 0;
                currChar = currStr.charAt(j)
            currCount++
            if(j = currStr.size() - 1)
                newStr+= currCount + currChar
        currStr = newStr;

 */
    static String countAndSay(int A) {
        String currStr = "1";
        for(int i = 2; i <= A; i++){
            int currCount = 0;
            String newStr = "";
            char currChar = currStr.charAt(0);
            for(int j = 0; j < currStr.length(); j++) {
                if(currChar != currStr.charAt(j)) {
                    newStr += currCount + Character.toString(currChar);
                    currCount = 0;
                    currChar = currStr.charAt(j);
                }
                currCount++;
                if(j == currStr.length() - 1)
                    newStr += currCount + Character.toString(currChar);
            }
            currStr = newStr;
        }
        return currStr;
    }
}
