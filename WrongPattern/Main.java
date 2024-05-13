public class Main {
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String [] words = s.split(" ");
            if(pattern.length()!= words.length){
                return false;
            }
            String [] dict = new String [26];
            Map<String, Character> hMap = new HashMap<>();
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
        boolean notPresentInDict(char c, String [] dict){

        }
        boolean notPresentInMap(String word, Map<String, Character> map){

        }
        void addCurrentWordInDictAndMap(char curr, String [] dict, String word, Map<String, Character>map){

        }

        boolean  checkMapping(char curr, String [] dict, String word, Map<String, Character>map){

        }

    }
}
