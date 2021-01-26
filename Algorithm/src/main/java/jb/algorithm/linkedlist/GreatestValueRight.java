package jb.algorithm.linkedlist;

/**
 * @author jbhushan
 */
public class GreatestValueRight {

    public static void main(String[] args){
        ListNode l1 = null;
        ListNode l3 = new ListNode(40,l1);
        ListNode l2 = new ListNode(30,l3);
        l1 = new ListNode(12,l2);
        ListNode head = new ListNode(10,l1);

      //  System.out.println(detectLoop(head));
    }

    private static void reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static Node updateArbitary(Node head){

        reverse(head);
        Node max = head;
        Node temp = null;
        while(temp!=null){
            temp.random = max;
            if(max.val < temp.val){
                max = temp;
            }
            temp = temp.next;
        }
        reverse(head);
        return head;
    }
}
