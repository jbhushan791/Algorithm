package jb.algorithm.dp.lcs;

/**
 * @author jbhushan
 */
public class LongestCommonSubstring {

    public static void main(String[] args){
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        lcs.lcs("abcde","abfce");
        lcs.lcs("zxabcdezy","yzabcdezx");
    }

    private int lcs(String s1, String s2){
        int[][] t = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<s1.length()+1;i++){
            for(int j=0; j<s2.length()+1;j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<s1.length()+1; i++) {
            for (int j=1; j<s2.length()+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                    max = Math.max(max,t[i][j]);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        System.out.println("LCS "+max);
        return  max;
    }
}
