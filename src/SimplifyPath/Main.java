package SimplifyPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String path= "/.../a/../b/c/../d/./";
        Stack<String> st = new Stack<>();


        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String [] pathArr = path.split("/");
        for (String s : pathArr) {
            if (s.equals("..")) {
                if (!st.isEmpty())
                    st.pop();
            } else if (s.isEmpty() || s.equals(".")) {
                continue;
            } else {
                st.push(s);
            }
        }
        List<String> ls = new ArrayList<>();
        while(!st.isEmpty()){
            ls.add(st.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i= ls.size()-1;i>=0; i--){
            sb.append("/").append(ls.get(i));
        }
        return sb.isEmpty() ?"/":sb.toString();


    }
}
