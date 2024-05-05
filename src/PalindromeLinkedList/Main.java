package PalindromeLinkedList;

import java.util.List;

public class Main {

    /**
     * Definition for singly-linked list.*/
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

    public static void main(String[] args) {
        ListNode head = convertArrToLinkedList(new int [] {1,2,2,1});
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        int [] arr = new int [100000];
        ListNode temp = head;
        int total = 0;
        while(temp!=null){

            arr[total] = temp.val;
            total++;
            temp = temp.next;
        }


        return checkPalindrome(arr, total-1);
    }

    static boolean  checkPalindrome(int [] arr, int j){
        int i = 0;
        while(i<j){
            if(arr[i]!=arr[j])
                return false;
            i++;j--;
        }
        return true;
    }

}
