package SubStringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println( findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordMap  = formMap(words);
        List<Integer> indexes = new ArrayList<>();
        int totalWords = words.length;
        int wordLen = words[0].length();
        int stringLen = s.length();
        for(int i =0; i< stringLen- totalWords*wordLen+1; ++i){
            Map<String, Integer> currentMap = new HashMap<>();
            int j =0;
            while(j< totalWords){
                String currentWord = s.substring(i+j*wordLen, i+(j+1)*wordLen);
                if(!(wordMap.containsKey(currentWord))
                        || wordMap.get(currentWord)<
                        currentMap.getOrDefault(currentWord, 0)+1){
                    break;
                }
                else{
                    currentMap.put(currentWord, currentMap.getOrDefault(currentWord, 0)+1);
                }
                j++;
            }
            if(j==totalWords){
                indexes.add(i);
            }

        }

        return indexes;


    }

    static Map<String, Integer> formMap (String [] s){
        Map<String, Integer> hMap = new HashMap<>();
        for(int i= 0; i< s.length; ++i){
            hMap.put(s[i], hMap.getOrDefault(s[i], 0)+1);
        }
        return hMap;
    }
}
