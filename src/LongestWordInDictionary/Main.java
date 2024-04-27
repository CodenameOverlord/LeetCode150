package LongestWordInDictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"a", "ab", "d", "x", "xe", "xef"}));
    }
    public static String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> hSet = new HashSet<>();
        String ans = "";
        for(String s: words){
            if(s.length()==1||hSet.contains(s.substring(0, s.length()-1))){
                if(s.length()>ans.length()){
                    ans = s;
                }
                hSet.add(s);

            }
        }

        return ans;

    }
}
