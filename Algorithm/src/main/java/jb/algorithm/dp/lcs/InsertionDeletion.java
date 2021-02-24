package jb.algorithm.dp.lcs;

/**
 * @author jbhushan
 */
public class InsertionDeletion {

    public static void main(String[] args){

        InsertionDeletion insertionDeletion = new InsertionDeletion();
        insertionDeletion.totalOperations("heap","pea");
        insertionDeletion.totalOperations("geeksforgeeks","geeks");

    }

    private int totalOperations(String source, String destination){
        int[][] t = new int[source.length()+1][destination.length()+1];
        for(int i=0; i<source.length()+1; i++){
            for(int j=0; j<destination.length()+1; j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }

        for(int i=1; i<source.length()+1; i++) {
            for (int j = 1; j < destination.length() + 1; j++) {
                if(source.charAt(i-1) == destination.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }

        int i = source.length();
        int j = destination.length();
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(source.charAt(i-1) == destination.charAt(j-1)){
                sb.append(source.charAt(i-1));
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

        String lcs = sb.reverse().toString();
        int operations = source.length()-lcs.length() + destination.length()-lcs.length();
        System.out.println("Total deletions: "+(source.length()-lcs.length()));
        System.out.println("Total insertions: "+(destination.length()-lcs.length()));
        System.out.println();
        return operations;

    }
}
