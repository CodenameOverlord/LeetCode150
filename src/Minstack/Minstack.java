package Minstack;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> mini;

    public MinStack() {
        stack = new Stack<Integer>();
        mini = new Stack<Integer>();
    }

    public void push(int val) {
        stack.push(val);
        if(mini.isEmpty()|| mini.peek()>val){
            mini.push(val);
        }else{
            mini.push(mini.peek());
        }
    }

    public void pop() {
        mini.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mini.peek();
    }
}
