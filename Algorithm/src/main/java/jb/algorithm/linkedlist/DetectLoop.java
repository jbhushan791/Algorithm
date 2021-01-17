package jb.algorithm.linkedlist;

/**
 * @author jbhushan
 */
public class DetectLoop {

    public static void main(String[] args){
        ListNode l1 = null;
        ListNode l3 = new ListNode(40,l1);
        ListNode l2 = new ListNode(30,l3);
        l1 = new ListNode(12,l2);
        ListNode head = new ListNode(10,l1);

        System.out.println(detectLoop(head));
    }

    public static boolean detectLoop(ListNode head){

        ListNode pointer = head;
        ListNode fast = pointer;
        ListNode slow = pointer;

        while(slow!=null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
