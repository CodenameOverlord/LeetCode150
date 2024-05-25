package ReverseLinkedList2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode past = new ListNode(1);
        ListNode head = past;
        for (int i = 2; i <= 2; i++) {
            ListNode temp = new ListNode(i);
            past.next = temp; past = temp;
        }


        ListNode temp = reverseBetween(head, 1, 2);
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        //find left unchanged and right unchanged
        ListNode leftUnchanged = pointPrevNode(head, left);
        ListNode rightLast = pointPrevNode(head, right).next;
        ListNode rightUnchanged = rightLast.next;
        rightLast.next = null;
        //connect to leftUnchanged and rightUnchanged
        if(left == 1){
            Map<String,ListNode> listMap =
                    reverseNode(head);
            listMap.get("tail").next = rightUnchanged;
            head= listMap.get("head");
        }else{
            Map<String,ListNode> listMap =
                    reverseNode(leftUnchanged.next);
            listMap.get("tail").next = rightUnchanged;
            leftUnchanged.next = listMap.get("head");
        }
        return head;
    }
    static ListNode pointPrevNode(ListNode head, int pos){
        int i = 1;
        ListNode temp = head;
        while(temp!=null && i<pos-1){
            temp = temp.next;
            i++;
        }
        return temp;
    }

    static Map<String, ListNode> reverseNode(ListNode head){
        Map<String, ListNode> listMap = new HashMap<>();
        if(head == null || head.next == null){
            listMap.put("head", head);
            listMap.put("tail", head);
            return listMap;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null)
                next = next.next;
        }
        head.next = null;
        listMap.put("head", prev);
        listMap.put("tail", head);
        return listMap;
    }
}
