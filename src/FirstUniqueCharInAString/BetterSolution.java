package FirstUniqueCharInAString;

import java.util.ArrayList;
import java.util.List;

public class BetterSolution {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));

    }
    public static int firstUniqChar(String s) {
        int [] repeat = new int [26];
        char [] charArr = s.toCharArray();

        for(int i = 0; i< charArr.length;++i){
            char currChar = charArr[i];
            repeat[currChar-'a']++;
        }

        for(int i=0; i< charArr.length;++i)
        {
            if(repeat[charArr[i]-'a']==1){
                return i;
            }
        }

        return -1;


    }

}
