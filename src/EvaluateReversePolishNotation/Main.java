package EvaluateReversePolishNotation;

import java.util.Stack;

public class Main {
    public int evalRPN(String[] tokens) {
        Stack<Integer> store = new Stack<>();
        int i = 0;
        if(tokens.length==1){
            return Integer.parseInt(tokens[0]);
        }

        while(i<tokens.length){
            String currentChar = tokens[i];
            if(isOperand(currentChar)){
                int data2 = store.pop();
                int data1 = store.pop();
                store.add(operate(data1, data2, currentChar));
            }
            else{
                store.add(Integer.parseInt(currentChar));
            }
            i++;
        }
        return store.pop();
    }

    public int operate(int data1, int data2, String currentChar){
        switch(currentChar){
            case "+": return data1+data2;
            case "-": return data1-data2;
            case "/": return data1/data2;
            case "*": return data1*data2;
        }
        return 0;
    }

    public boolean isOperand(String currentChar){
        switch(currentChar){
            case "+": return true;
            case "-": return true;
            case "/": return true;
            case "*": return true;
        }
        return false;
    }
}
