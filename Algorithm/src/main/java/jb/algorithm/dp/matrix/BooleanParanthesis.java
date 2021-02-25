package jb.algorithm.dp.matrix;

/**
 * @author jbhushan
 */
public class BooleanParanthesis {

    public static void main(String[] args){

    }

    private int booleanParanthesis(String s){
        int i = 0;
        int j = s.length()-1;
        count(s,i,j,true);
    }

    private boolean count(String s, int i, int j, boolean b) {
        if(i>j){
            return 0;
        }
    }
}
