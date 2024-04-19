package Merge2List;

public class Main {
    public static void main(String[] args) {
        ListNode listNode11= new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13= new ListNode(4);
        listNode11.next = listNode12; listNode12.next = listNode13;


        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(2);
        ListNode listNode23 = new ListNode(3);

        listNode21.next = listNode22; listNode22.next = listNode23;

        printList(Solution.mergeTwoLists(listNode11,listNode21));



    }

    private static void printList(ListNode listNode) {
        ListNode temp = listNode;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    static class Solution {
        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode temp1 = list1;
            ListNode temp2 = list2;
            if(temp1==null){
                return temp2;
            }
            if(temp2== null){
                return temp1;
            }
            ListNode head = null;
            ListNode current = null;
            while(temp1!=null && temp2!=null){
                if(head == null){
                    if(temp1.val<temp2.val){
                        head = temp1;
                        temp1 = temp1.next;
                    }
                    else{
                        head = temp2;
                        temp2 = temp2.next;
                    }
                    current = head;
                }
                else{
                    if(temp1.val<temp2.val){
                        current.next = temp1;
                        temp1 = temp1.next;
                    }
                    else{
                        current.next= temp2;
                        temp2 = temp2.next;
                    }
                    current = current.next;
                }
            }

            if(temp1!= null){
                current.next =  temp1;
            }
            if(temp2!=null){
                current.next = temp2;
            }

            return head;

        }
    }
}
