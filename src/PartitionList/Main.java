package PartitionList;

public class Main {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode partition(ListNode head, int x) {
        ListNode superHeadG = new ListNode(0);
        ListNode superHeadL = new ListNode(0);

        ListNode tempG = superHeadG; ListNode tempL= superHeadL;
        ListNode temp =head;
        while(temp!=null){
            if(temp.val <x){
                tempL.next = temp;
                tempL = temp;
                temp = temp.next;
                tempL.next = null;
            }
            else{
                tempG.next = temp;
                tempG = temp;
                temp = temp.next;
                tempG.next = null;
            }
        }
        tempL.next = superHeadG.next;
        return superHeadL.next;

    }



}

