package jb.algorithm.dp.lcs;

import java.util.Arrays;

/**
 * @author jbhushan
 */
public class LCSRecursive {

    public static void main(String[] args){
        LCSRecursive lcsRecursive = new LCSRecursive();
        lcsRecursive.l("ABCDGH", "AEDFHR");
        lcsRecursive.l("AGGTAB", "GXTXAYB");
    }

    private int l(String s1, String s2){
        if(s1.length() == 0 || s2.length() == 0){
            return 0;
        }
        int t[][] = new int[s1.length()+1][s2.length()+1];
        //Arrays.fill(t,-1);
        for(int i=0; i<s1.length()+1; i++){
            for(int j=0; j<s2.length()+1; j++){
                t[i][j] = -1;
            }
        }
        int len = lcs(s1,s2,s1.length(), s2.length(),t);
        System.out.println("LCS "+len);
        return len;
    }

    private int lcs(String s1, String s2, int n, int m, int[][] t){
        if(m==0 || n==0){
            return 0;
        }
        if(t[n][m] != -1){
            return t[n][m];
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            t[n][m] = 1 + lcs(s1, s2, n-1, m-1, t);
        } else {
            t[n][m] =  Math.max(lcs(s1, s2, n, m-1, t),lcs(s1, s2, n-1, m, t));
        }

        return  t[n][m];
    }
}
