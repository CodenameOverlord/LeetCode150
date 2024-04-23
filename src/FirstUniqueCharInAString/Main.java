package FirstUniqueCharInAString;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));

    }
    public static int firstUniqChar(String s) {
        int [] firstLoc = new int [26];
        int [] repeat = new int [26];
        for(int i=0; i<firstLoc.length; ++i){
            firstLoc[i]=-1;
        }

        for(int i = 0; i< s.length();++i){
            int currChar = s.charAt(i);
            repeat[currChar-'a']++;
            if(firstLoc[currChar-'a']==-1){
                firstLoc[currChar-'a']=i;
            }
        }
        List<Integer> nonRepeat = new ArrayList<>();

        for(int i =0; i< repeat.length;++i){
            if(repeat[i]==1){
                nonRepeat.add(i);
            }
        }
        if(nonRepeat.size()==0){
            return -1;
        }
        int minPost = Integer.MAX_VALUE;
        for(int i : nonRepeat){
            minPost = Math.min(firstLoc[i], minPost);
        }

        return minPost;


    }
}
