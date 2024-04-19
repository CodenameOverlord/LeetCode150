package Merge2List;

public class BetterApproachRecursion {
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
            if(list1!=null && list2!=null) {
                if (list1.val < list2.val) {
                    list1.next = mergeTwoLists(list1.next, list2);
                    return list1;
                } else {
                    list2.next = mergeTwoLists(list1, list2.next);
                    return list2;
                }
            }

            if(list1==null){
                return list2;
            }
            else{
                return list1;
            }
        }
    }


}






