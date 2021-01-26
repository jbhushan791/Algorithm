package jb.algorithm.linkedlist;

/**
 * This class is responsible for finding middle element of linked list
 *
 * @author jbhushan
 */
public class MergeTwoSortedList {
    public static void main(String[] args){
        ListNode l3 = new ListNode(11,null);
        ListNode l2 = new ListNode(0,null);
        ListNode l1 = new ListNode(8,l2);
        ListNode head = new ListNode(7,l1);
    }

    private static ListNode merge(ListNode h1, ListNode h2){

        if(h1 == null){
            return h2;
        }
        if(h2 == null){
            return h1;
        }

        ListNode merged = null;
        ListNode temp = null;

        // initialize head
        if(h1.val <= h2.val){
            merged = h1;
            h1= h1.next;
        } else {
            merged = h2;
            h2= h2.next;
        }
        temp = merged;

        while(h1 != null && h2 !=null){
            if(h1.val <= h2.val){
                temp.next = h1;
                h1= h1.next;
            } else {
                temp.next = h2;
                h2= h2.next;
            }
            temp = temp.next;
        }

        if(h1 != null){
            temp.next = h1;
        } else {
            temp.next = h2;
        }

        return merged;
    }


}
