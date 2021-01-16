package jb.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for finding middle element of linked list
 *
 * @author jbhushan
 */
public class FindKthElement {
    public static void main(String[] args){
        ListNode l3 = new ListNode(11,null);
        ListNode l2 = new ListNode(0,l3);
        ListNode l1 = new ListNode(8,l2);
        ListNode head = new ListNode(7,l1);
        findKthElement(head,2);
    }

    private static ListNode findKthElement(ListNode head, int k){
        ListNode pointer =  head;
        ListNode front = pointer;
        ListNode back = pointer;
        // if k > n then front == null -- handle this
        for(int i=1; i<k && front!=null;i++){
            front = front.next;
        }
        if(front == null){
            return null;
        }

        while(front.next != null){
            back=back.next;
            front = front.next;
        }
        System.out.println(k+" Element from end "+back.val);
        return back;
    }


}
