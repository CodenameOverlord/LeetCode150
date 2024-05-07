package IntersectionOfTwoLinkedList;

public class FloydWarshallCyclePointAlgorithm {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {



    }

    static ListNode getIntersectionNode(ListNode A, ListNode B){
        ListNode tailA = formCycleAndReturnTailFirst(A, B);
        ListNode result = findPointIntersectionAndReorganize(B, tailA);
        return result;

    }

    private static ListNode findPointIntersectionAndReorganize(ListNode headB, ListNode tailA) {
        ListNode slow = headB; ListNode fast = headB;
        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = headB;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                tailA.next = null;
                return fast;
            }
        }
        tailA.next = null;
        return null;
    }

    private static  ListNode formCycleAndReturnTailFirst(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        while(tempA.next!=null){
            tempA = tempA.next;
        }
        tempA.next = headA;
        return tempA;

    }
}
