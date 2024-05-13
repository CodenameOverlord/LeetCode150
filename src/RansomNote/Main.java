package RansomNote;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(canConstruct("randomWarte", "randomWarterrree"));
    }


    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap =getMapFromString(ransomNote);
        Map<Character, Integer> magMap = getMapFromString(magazine);
        return checkIfSubset(ransomMap, magMap);
    }

    public static Map<Character, Integer> getMapFromString(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0; j< s.length(); j++){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j))+1);
            }
            else{
                map.put(s.charAt(j), 1);
            }
        }
        return map;
    }

    public static boolean checkIfSubset(Map<Character, Integer>child, Map<Character, Integer> parent){
        for(Map.Entry<Character, Integer> x:child.entrySet()){
            if(parent.containsKey(x.getKey()) && parent.get(x.getKey())>=x.getValue()){

            }else{
                return false;
            }
        }
        return true;
    }
}
