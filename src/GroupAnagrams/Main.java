package GroupAnagrams;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==1){
            List<String> soln = Arrays.asList(strs);
            List<List<String>> arrayList =  new ArrayList<>();
            arrayList.add(soln);
            return arrayList;
        }
        Map<Map<Character, Integer>, List<String>> collection =
                collectStrings(strs);
        return convertToArrArrString(collection);
    }

    static Map<Map<Character, Integer>, List<String>> collectStrings(String[] strs){
        Map<Map<Character, Integer>, List<String>> collections =  new HashMap<>();
        for(String s: strs){
            addInCollections(collections, s);
        }
        return collections;
    }

    static void addInCollections(Map<Map<Character, Integer>, List<String>> collections, String s){
        Map<Character, Integer> charMap = allCharInMap(s);
        if(collections.containsKey(charMap)){
            List<String> stringWithAnagram = collections.get(charMap);
            stringWithAnagram.add(s);
        }
        else{
            List<String> stringWithAnagram = new ArrayList<>();
            stringWithAnagram.add(s);
            collections.put(charMap, stringWithAnagram);
        }
    }
    static Map<Character, Integer>  allCharInMap(String s){
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i< s.length(); ++i){
            Character currChar = s.charAt(i);
            if(charMap.containsKey(currChar)){
                charMap.put(currChar, charMap.get(currChar)+1);
            }
            else{
                charMap.put(currChar, 1);
            }
        }
        return charMap;
    }

    static List<List<String>> convertToArrArrString
            (Map<Map<Character, Integer>, List<String>> collection)
    {
        List<List<String>> ans = new ArrayList<>();
        for(Map<Character, Integer> m : collection.keySet()){
            ans.add(collection.get(m));
        }
        return ans;
    }
}
