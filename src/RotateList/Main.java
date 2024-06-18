package RotateList;

public class Main {
  public class ListNode {
      int val;
      ListNode next;
 ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    class Pair{
        ListNode start,  end;
        Pair(ListNode start, ListNode end){
            this.start = start;this.end=end;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        int n = totalNodes(head);
        if(n==0 || n==1 || k%n==0){
            return head;
        }
        k= k%n;
        Pair p = breakNodeAfter(head, n-k);
        ListNode newStart = p.end;
        ListNode temp = newStart;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = p.start;
        return newStart;
    }

    int totalNodes(ListNode head){
        ListNode temp = head;
        if(temp == null)
            return 0;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    Pair breakNodeAfter(ListNode head, int n){
        // Pair p;
        ListNode temp = head;
        int count = 1;
        while(count<n){
            temp = temp.next;
            count++;
        }
        ListNode end = temp.next;
        temp.next = null;
        Pair p = new Pair(head, end);
        return p;

    }
}
