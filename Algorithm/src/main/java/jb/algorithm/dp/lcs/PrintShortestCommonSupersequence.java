package jb.algorithm.dp.lcs;

/**
 * @author jbhushan
 */
public class PrintShortestCommonSupersequence {

    public static void main(String[] args){
        PrintShortestCommonSupersequence scs = new PrintShortestCommonSupersequence();
        scs.scs("geek","eke");
        scs.scs("AGGTAB","GXTXAYB");
        scs.scs("HELLO","GEEK");

    }

    private String scs(String s1, String s2){
        String scs = getScs(s1, s2);
        System.out.println("ShortestCommonSupersequence length: "+scs);
        return  scs;
    }

    private String getScs(String s1, String s2) {
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
                    sb.append(s1.charAt(i-1));
                    i--;
                } else {
                    sb.append(s2.charAt(j-1));
                    j--;
                }
            }
        }

        while (i>0){
            sb.append(s1.charAt(i-1));
            i--;
        }

        while (i>0){
            sb.append(s2.charAt(j-1));
            j--;
        }

        String s = sb.reverse().toString();
        return s;
    }
}
