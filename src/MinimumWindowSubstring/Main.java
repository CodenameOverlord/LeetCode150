package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(minWindow("ABC", "B"));
    }
    public static String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        Map<Character, Integer> tMap = convertStrToCharMap(t); int sI =0; int eI= 0;
        Map<Character, Integer> sMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE, ansSI = 0, ansEI = 0;
        while(eI< t.length()){
            char currChar = s.charAt(eI);
            updateCharOnMap(sMap, currChar);
            eI++;
        }
        eI--;
        while(eI+1<s.length()){
            if(compareMap(sMap, tMap)){
                //updateMinString, updateStartIndexAns, updateEndIndexAns, and
                //increment sI and update map
                int currLen = eI-sI+1;
                if(currLen<minLen){
                    ansSI = sI; ansEI = eI;
                    minLen = currLen;
                }
                while(sI<=eI && compareMap(sMap, tMap)){
                    //updateMap
                    currLen = eI-sI+1;
                    if(currLen<minLen){
                        ansSI = sI; ansEI = eI;
                        minLen = currLen;
                    }
                    char temp = s.charAt(sI);
                    sMap.put(temp, sMap.get(temp)-1);
                    sI++;
                }
            }
            else{
                //IncludeEndCharAndImplement
                eI++;
                char endChar = s.charAt(eI);
                updateCharOnMap(sMap, endChar);

            }
        }

        while(sI<s.length() && compareMap(sMap, tMap)){
            //updateMinifPossible
            int currLen =  eI-sI+1;
            if(currLen<minLen){
                ansSI = sI; ansEI = eI;
                minLen = currLen;
            }
            //increment sI and update map
            char temp = s.charAt(sI);
            sMap.put(temp, sMap.get(temp)-1);
            sI++;
        }

        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        else{
            return formString(ansSI, ansEI, s);//done
        }
    }

    static Map<Character, Integer> convertStrToCharMap(String s){
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i =0; i< s.length(); ++i){
            char currChar = s.charAt(i);
            if(sMap.get(currChar)==null)
                sMap.put(currChar, 1);
            else
                sMap.put(currChar, sMap.get(currChar)+1);
        }

        return sMap;
    }

    static void updateCharOnMap(Map<Character, Integer> sMap, char x){
        if(sMap.get(x)==null)
            sMap.put(x, 1);
        else
            sMap.put(x, sMap.get(x)+1);

    }

    static String formString(int sI, int eI, String s){
        StringBuilder sb = new StringBuilder();
        for(int i =sI; i<=eI; ++i){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    static boolean compareMap(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        for(Map.Entry<Character, Integer> entry: tMap.entrySet()){
            Integer sMapVal = sMap.get(entry.getKey());
            if(!(sMapVal!=null && sMapVal>=entry.getValue())){
                return false;
            }
        }
        return true;
    }
}
