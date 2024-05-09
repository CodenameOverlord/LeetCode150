package ReverseLinkedList;


public class Main {
    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }

        ListNode prev = head;
        ListNode current = head.next;
        ListNode next = current.next;
        while(current!=null){
            current.next = prev;
            prev = current;
            current = next;
            if(next!=null)
                next = next.next;
        }
        head.next =  null;
        return prev;
    }

}
