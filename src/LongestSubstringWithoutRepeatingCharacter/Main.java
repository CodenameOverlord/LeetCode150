package LongestSubstringWithoutRepeatingCharacter;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbaabc"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int start = 0;
        int end =0;
        int len = s.length();
        if(len==0||len==1)
            return len;
        Map<Character, Integer> hMap = new HashMap<>();

        int maxLen = 0;
        int currLen = 0;
        while(end<len){
            Character currChar = s.charAt(end);
            if(hMap.get(currChar)==null){
                //if current Character is new, add currentCharacter to currLen
                currLen++;
                hMap.put(currChar, end);
                maxLen=Math.max(currLen, maxLen);
            }
            else{
                //else update and deduct from currLen those character which has already occurred in the index
                //before the lastRepeated index, ie, the occurrence of the first repeating character
                int lastRepeatedIndex = hMap.get(currChar);
                for(Character itrChar: hMap.keySet())
                {
                    if(hMap.get(itrChar)!= null && hMap.get(itrChar)<lastRepeatedIndex){
                        hMap.put(itrChar, null);
                        currLen--;
                    }
                }
                hMap.put(currChar, end);
            }
            end++;
        }

        return maxLen;

    }
}
