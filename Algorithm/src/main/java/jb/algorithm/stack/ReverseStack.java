package jb.algorithm.stack;

import java.util.Stack;

/**
 * @author jbhushan
 */
public class ReverseStack {

    public static void main(String[] args){

    }

    public void reverse(Stack<Integer> top){
        if(!top.isEmpty()){
            Integer item = top.pop();
            reverse(top);
            insertAtBottom(top, item);
        }
    }

    private void insertAtBottom(Stack<Integer> top, Integer item) {
        if(!top.isEmpty()){
           // sta
        }
    }
}
