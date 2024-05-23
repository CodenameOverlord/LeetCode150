package CopyListWithRandomPointer;

public class Main {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }



    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node temp = head;
        //insert new Nodes in between
        while(temp!=null){
            Node newNode = new Node (temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
        // adjust the random pointers
        while(temp!=null){
            if(temp.random == null){
                temp.next.random = null;
            }
            else{
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        //rearrange old and new nodes
        temp = head;
        Node newHead = temp.next;
        while(temp!=null){
            Node newNext = temp.next;
            temp.next = temp.next.next;
            if(newNext.next!=null)
                newNext.next = newNext.next.next;
            temp = temp.next;
        }
        return newHead;
    }
}
