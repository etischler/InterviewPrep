package DynamicProgramming;

public class InterleavingStrings {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));//true
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));//false
    }

    static int isInterleave(String A, String B, String C) {
        if(A.length() + B.length() > C.length())
            return 0;
        if(A.length() == 0 && B.length() == 0 && C.length() == 0)
            return 1;
        char topCChar = C.charAt(0);
        int aValue = 0;
        int bValue = 0;
        if(A.length() > 0 && A.charAt(0) == topCChar){
            aValue = isInterleave(A.substring(1), B, C.substring(1));
        }
        if(B.length() > 0 && B.charAt(0) == topCChar){
            bValue = isInterleave(A, B.substring(1), C.substring(1));
        }

        return Math.max(aValue, bValue);

    }
}
