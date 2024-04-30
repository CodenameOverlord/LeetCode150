package LinkedListCycle;

public class Main {
    public static void main(String[] args) {

    }
     static class ListNode {
         int val;
         ListNode next;
              ListNode(int x) {
                  val = x;
                  next = null;
              }
          }
    public static boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow!=null && fast!=null && fast.next!=null && slow!=fast ){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast==null || fast.next ==null)
            return false;

        return true;
    }
}
