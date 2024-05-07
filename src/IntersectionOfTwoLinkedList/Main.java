package IntersectionOfTwoLinkedList;

import java.util.HashSet;
import java.util.Set;

public class Main {
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
        Set<ListNode> s = new HashSet<>();
        ListNode tempA = headA;
        while(tempA!=null){
            s.add(tempA);
            tempA = tempA.next;
        }

        ListNode tempB = headB;
        while(tempB!=null){
            if(s.contains(tempB)){
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }

}
