package IntersectionOfTwoLinkedList;

import java.util.HashSet;
import java.util.Set;

public class OptimizedSoln {
    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static ListNode convertArrToLinkedList(int [] arr){
        ListNode head = new ListNode(0, null);
        ListNode temp  = head;
        for (int i =0; i< arr.length; ++i){
            int element = arr[i];
            temp.next = new ListNode(element, null);
            temp = temp.next;
        }

        return head.next;

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Floyd warshall 2 pointer approach in which we traverse to the end of the first linked list
//        and then connect the first linked list to the end of the second linked list.
//        now if there is cycle in the connected linked list
//        then ther is intersection point
        return null;
    }
}
