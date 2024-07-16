package lruCache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static class LRUCache {
        class Node{
            int key;
            int val;
            Node prev;
            Node next;
            Node(int key, int x, Node prev, Node next){
                this.key = key;
                this.val = x;
                this.prev = null;
                this.next = null;
            }
            Node(int key, int val){
                this.val = val;
                this.key = key;
                this.prev = null;
                this.next = null;
            }
        }

        int cap = 0; int currentSize = 0;
        Map<Integer, Node> hMap = null;
        Node first=null; Node last = null;
        public LRUCache(int capacity) {
            cap = capacity;
            currentSize = 0;
            hMap = new HashMap<>();
        }
        void addBeforeFirst(Node x){
            if(first == null){
                first = x;
                last = x;
            }
            else{
                x.next = first;
                first.prev = x;
                first = x;
            }
        }
        void remove(Node x){
            if(x==first && x== last){
                first = null;
                last  = null;
            }
            else if(x==first){
                first = x.next;
                x.next = null;
                first.prev = null;
            }
            else if (x==last){
                last =x.prev;
                last.next = null;
                x.prev = null;
            }
            else{
                x.next.prev = x.prev;
                x.prev.next = x.next;
                x.prev = null;
                x.next = null;
            }
        }
        void removeAndRemoveFromHMap(Node x){
            remove(x);
            hMap.remove(x.key);
        }
        public int get(int key) {
            if(hMap.containsKey(key)){
                Node x = hMap.get(key);
                System.out.println(key);
                remove(x);
                addBeforeFirst(x);
                return x.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node newNode = new Node(key, value);
            if(hMap.containsKey(key)){
                Node past = hMap.get(key);
                remove(past);
                addBeforeFirst(newNode);
            }
            else{
                if(first==null){
                    first = newNode;
                    last = newNode;
                    currentSize = 1;
                }
                else{
                    if(currentSize == cap){
                        removeAndRemoveFromHMap(last);
                    }
                    else{
                        currentSize++;
                    }
                    addBeforeFirst(newNode);
                }

            }
            hMap.put(key, newNode);

        }
    }


    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.put(1,0);
        l.put(2,2);
        l.get(1);
        l.put(3,3);
        l.get(2);
        l.put(4,4);
        l.get(1);
        l.get(3);
        l.get(4);

    }
}
