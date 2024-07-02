package BasicCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
    public static int calculate(String s) {
        int ans = 0;
        Stack<String> st = new Stack<>();
        for(int i =0; i<s.length();++i){
            char c = s.charAt(i);
            if(c==' '){
                continue;
            }
            if(c==')'){
                operate(st);
            }
            else if(c=='('){
                st.push(c+"");
            }
            else if(c=='+'|| c=='-'){
                st.push(c+"");
            }
            else{
                int j=i;
                StringBuilder sb=  new StringBuilder();
                while(j<s.length() && (isNumber(s,j))){
                    sb.append(s.charAt(j));j++;
                }
                st.push(sb.toString());
                i=j-1;
            }
        }
        operate(st);
        return Integer.parseInt(st.pop());
    }

    static void operate(Stack<String> st){
        List<String> currentExp = new ArrayList<>();
        while(!st.isEmpty() && !st.peek().equals("(")){
            currentExp.add(st.pop());
        }
        if(!currentExp.isEmpty() && !isOperand(currentExp.get(currentExp.size()-1)))
            currentExp.add("+");
        int ans = solveReverse(currentExp);
        if(!st.isEmpty() && Objects.equals(st.peek(), "(")){
            st.pop();
        }
        st.push(ans+"");
    }

    static int  solveReverse(List<String> reverseExp){
        int ans = 0;
        int i=0;
        while(i<reverseExp.size()){
            ans +=Integer.parseInt(reverseExp.get(i))*(reverseExp.get(i+1).equals("+")?1:-1);
            i+=2;
        }
        return ans;
    }

    static boolean  isOperand(String x){
        if(x.equals("+") || x.equals("-")){
            return true;
        }
        return false;
    }

    static boolean  isNumber(String x, int pos){
        if(x.charAt(pos)>='0' && x.charAt(pos)<='9')
            return true;
        return false;
    }
}
