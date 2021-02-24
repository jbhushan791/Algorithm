package jb.algorithm.dp.lcs;

/**
 * @author jbhushan
 */
public class ShortestCommonSupersequence {

    public static void main(String[] args){
        ShortestCommonSupersequence scs = new ShortestCommonSupersequence();
        scs.scs("geek","eke");
        scs.scs("AGGTAB","GXTXAYB");

    }

    private int scs(String s1, String s2){
        String lcs = getLcs(s1, s2);
        System.out.println("ShortestCommonSupersequence length: "+(s1.length()+s2.length()-lcs.length()));
        return  s1.length()+s2.length()-lcs.length();
    }

    private String getLcs(String s1, String s2) {
        int[][] t = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i< s1.length()+1; i++){
            for(int j = 0; j< s2.length()+1; j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }

        for(int i = 1; i< s1.length()+1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                } else {
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }

        int i = s1.length();
        int j = s2.length();
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                if(t[i-1][j] > t[i][j-1]){
                    i--;
                } else {
                    j--;
                }
            }
        }

        String s = sb.reverse().toString();
        return s;
    }
}
