package jb.algorithm.dp.lcs;

/**
 * @author jbhushan
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args){
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        lps.lps("geeksforgeeks");

    }

    private int lps(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        String reverse = sb.toString();

        int len = lcs(s,reverse);
        System.out.println(" Length of longest palindrome subsequence: "+len);
        return len;
    }

    private int lcs(String s, String reverse) {
        int[][] t = new int[s.length()+1][reverse.length()+1];
        for(int i=0; i<s.length()+1; i++){
            for(int j=0; j<reverse.length()+1; j++){
                if(i==0 || j==0) {
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1; i<s.length()+1; i++){
            for(int j=1; j<reverse.length()+1; j++){
                if(s.charAt(i-1) ==  reverse.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[s.length()][reverse.length()];
    }
}
