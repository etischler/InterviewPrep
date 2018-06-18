package Strings;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    static String reverseWords(String a) {
       a.replaceAll("\\s{2,}", " ").trim();
       if(a.charAt(0) == ' ')
           a = a.substring(1, a.length());
       if(a.charAt(a.length() - 1) == ' ')
           a = a.substring(0, a.length() - 1);
       String[] toReverse = a.split(" ");
       String newA = "";
       for(int i = toReverse.length - 1; i > -1; i--) {
           newA += toReverse[i];
           if(i != 0)
               newA += " ";
       }
       return newA;
    }
}
