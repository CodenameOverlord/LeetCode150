package RemoveDuplicatesFromSortedList2;

public class Main {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        if(head==null || head.next == null){
            return head;
        }
        ListNode current = prev.next;
        if(prev.val == current.val){
            head = nonDuplicateHead(head);
        }
        if(head==null || head.next == null){
            return head;
        }

        prev = head;
        current = head.next;
        ListNode next = current.next;
        while(next!=null){
            if(current.val == next.val){
                while(next!=null && current.val == next.val){
                    next = next.next;
                }
                current = next;
                prev.next = current;
                if(current!=null)
                    next = current.next;
            }
            else{
                prev = current;
                current = current.next;
                next = current.next;
            }
        }

        return head;
    }

    ListNode nonDuplicateHead(ListNode head){
        if(head == null || head.next==null){
            return head;
        }
        ListNode temp = head.next;
        if(temp.val!=head.val){
            return head;
        }
        while(temp!=null && temp.val==head.val ){
            temp=temp.next;
        }
        head = temp;
        return nonDuplicateHead(head);

    }
}
