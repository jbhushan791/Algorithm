package jb.algorithm.dp.lcs;

/**
 * @author jbhushan
 */
public class LCSTopDown {

    public static void main(String[] args){
        LCSTopDown lcsRecursive = new LCSTopDown();
        lcsRecursive.lcs("ABCDGH", "AEDFHR");
        lcsRecursive.lcs("AGGTAB", "GXTXAYB");
    }

    private int lcs(String s1, String s2){
        if(s1.length() == 0 || s2.length() == 0){
            return 0;
        }
        int t[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<s1.length()+1; i++){
            for(int j=0; j<s2.length()+1; j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1; i<s1.length()+1; i++){
            for(int j=1; j<s2.length()+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        System.out.println("LCS "+t[s1.length()][s2.length()]);
        return t[s1.length()][s2.length()];
    }

}
