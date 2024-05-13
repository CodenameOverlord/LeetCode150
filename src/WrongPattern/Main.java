package WrongPattern;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        the idea is to check whether the data present in char vs string and string vs char are same or not
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
    public static boolean wordPattern(String pattern, String s) {
        String [] words = s.split(" ");
        if(pattern.length()!= words.length){
            return false;
        }
        String [] dict = new String [26];
        Map<String, Character> map = new HashMap<>();
        for(int i =0; i<pattern.length(); ++i){
            char curr = pattern.charAt(i);
            String word = words[i];
            if(notPresentInDict(curr, dict) && notPresentInMap(word, map)){
                addCurrentWordInDictAndMap(curr, dict, word, map);
            }
            else if (notPresentInDict(curr, dict) || notPresentInMap(word, map)){
                return false;
            }
            else{
                if(!checkMapping(curr, dict, word, map)){
                    return false;
                }
            }
        }

        return true;
    }
    static boolean notPresentInDict(char c, String [] dict){
        return dict[c-'a']==null?true:false;
    }
    static boolean notPresentInMap(String word, Map<String, Character> map){
        return map.containsKey(word)?false:true;
    }
    static void addCurrentWordInDictAndMap(char curr, String [] dict, String word, Map<String, Character> map){
        dict[curr-'a']=word;
        map.put(word,curr);
    }

    static boolean  checkMapping(char curr, String [] dict, String word, Map<String, Character>map){
        String wordFromDict = dict[curr-'a'];
        char c = map.get(word);
        return wordFromDict.equals(word) && c==curr;
    }
}
