package jb.algorithm.dp.lcs;

/**
 * @author jbhushan
 */
public class MinDeletionToMakePalindrome {

    public static void main(String[] args){
        minDeletion("geeksforgeeks");
    }

    private static int minDeletion(String s){
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        int len = lps.lps(s);
        System.out.println("Min Deleteion: "+(s.length()-len));
        return s.length()-len;
    }
}
