package ValidParenthesis;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(isValid("([]{})"));
    }

    public static boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i< s.length(); ++i){
            char c = s.charAt(i);
            if(isOpen(c)){
                st.push(c);
            }
            else{
                if(!st.isEmpty())
                {
                    if(isOpposite(st.peek(),c)){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }else{
                    return false;

                }
            }
        }
        return st.isEmpty();
    }

    static boolean isOpposite(char x, char y){
        String total = x+""+y;
        return switch (total) {
            case "()" -> true;
            case "{}" -> true;
            case "[]" -> true;
            default -> false;
        };
    }

    static boolean isOpen(char c){
        return switch (c) {
            case '(' -> true;
            case '{' -> true;
            case '[' -> true;
            default -> false;
        };
    }
}
